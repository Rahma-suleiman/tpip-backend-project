package com.znz.tpip_backend.dto;

import lombok.Data;

@Data
public class PlacementDto {
    private Long id;

    private int mentor;
    private int school;
    
    private int intern;
}
