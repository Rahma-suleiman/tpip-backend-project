package com.znz.tpip_backend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SchoolDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String name;

    private String location;

    // reverse r/ship
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Long> placementIds;
}
