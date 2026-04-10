package com.znz.tpip_backend.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.znz.tpip_backend.enums.ExtensionStatus;

import lombok.Data;

@Data
public class ExtensionDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;

    private ExtensionStatus status;

    // forward r/ship
    private Long intern;

    private Long evaluation;
}
