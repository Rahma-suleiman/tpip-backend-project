package com.znz.tpip_backend.dto;

import lombok.Data;

@Data
public class EvaluationDto {
    private Long id;
    private int internId;
    private double score;
    private String remarks;
}
