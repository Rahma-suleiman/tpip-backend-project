package com.znz.tpip_backend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MentorDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    
    private String qualificationLevel;
    private String status;
    
    // reverse r/ships
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Long> feedbackIds;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Long> placementIds ;
}
