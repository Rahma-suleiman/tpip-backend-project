package com.znz.tpip_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.znz.tpip_backend.dto.EvaluationDto;
import com.znz.tpip_backend.service.EvaluationService;


@RestController
@RequestMapping("/api/v1/tpip/certificate")
public class EvaluationController {
      @Autowired
    private EvaluationService evaluationService;

    @GetMapping
    public ResponseEntity<List<EvaluationDto>> getAllEvaluations() {
        List<EvaluationDto> evaluations= evaluationService.getAllEvaluations();
        return new ResponseEntity<>(evaluations, HttpStatus.OK);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationDto> getEvaluationById(@PathVariable Long id) {
        EvaluationDto eva = evaluationService.getEvaluationById(id);
        return ResponseEntity.ok(eva);       
    }
  
    
    @PostMapping
    public ResponseEntity<EvaluationDto> addEvaluation(@RequestBody EvaluationDto evaluationDto) {
        EvaluationDto evaluation = evaluationService.addEvaluation(evaluationDto);
        return new ResponseEntity<>(evaluation, HttpStatus.CREATED);        
    }
    @PutMapping("/{id}")
    public ResponseEntity<EvaluationDto> editEvaluation(@PathVariable Long id, @RequestBody EvaluationDto evaluationDto){
        EvaluationDto evaluation = evaluationService.editEvaluation(id, evaluationDto);
        return new ResponseEntity<>(evaluation, HttpStatus.OK);        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long id) {
        evaluationService.deleteEvaluation(id);
        return ResponseEntity.noContent().build();
    }
}
