package com.znz.tpip_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znz.tpip_backend.dto.FeedbackDto;
import com.znz.tpip_backend.repository.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<FeedbackDto> getAllFeedbacks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllFeedbacks'");
    }

    public FeedbackDto getFeedbackById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFeedbackById'");
    }

    public FeedbackDto addExtension(FeedbackDto feedbackDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addExtension'");
    }

    public FeedbackDto editFeedback(Long id, FeedbackDto feedbackDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editFeedback'");
    }

    public void deleteFeedback(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFeedback'");
    }
}
