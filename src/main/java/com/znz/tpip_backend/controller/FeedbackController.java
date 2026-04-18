package com.znz.tpip_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.znz.tpip_backend.dto.FeedbackDto;
import com.znz.tpip_backend.service.FeedbackService;

@RestController
@RequestMapping("/api/v1/tpip/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<FeedbackDto>> getAllFeedbacks() {
        List<FeedbackDto> feedbacks = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDto> getFeedbackById(@PathVariable Long id) {
        FeedbackDto feedback = feedbackService.getFeedbackById(id);
        return ResponseEntity.ok(feedback);
    }

    @PostMapping
    public ResponseEntity<FeedbackDto> addFeedback(@RequestBody FeedbackDto feedbackDto) {
        FeedbackDto feedback = feedbackService.addFeedback(feedbackDto);
        return new ResponseEntity<>(feedback, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackDto> editFeedback(@PathVariable Long id, @RequestBody FeedbackDto feedbackDto) {
        FeedbackDto feedback = feedbackService.editFeedback(id, feedbackDto);
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}
