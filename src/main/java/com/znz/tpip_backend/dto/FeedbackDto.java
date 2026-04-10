package com.znz.tpip_backend.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FeedbackDto {
    private Long id;
    private int rating;
    private String comment;
    private LocalDate date;

    
    private int mentor;
    private int intern;
}
