package com.znz.tpip_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znz.tpip_backend.dto.EvaluationDto;
import com.znz.tpip_backend.repository.EvaluationRepository;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    public List<EvaluationDto> getAllEvaluations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEvaluations'");
    }

    public EvaluationDto getEvaluationById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEvaluationById'");
    }

    public EvaluationDto addEvaluation(EvaluationDto evaluationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEvaluation'");
    }

    public EvaluationDto editEvaluation(Long id, EvaluationDto evaluationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editEvaluation'");
    }

    public void deleteEvaluation(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEvaluation'");
    }
}
