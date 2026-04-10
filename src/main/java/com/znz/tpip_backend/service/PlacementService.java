package com.znz.tpip_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znz.tpip_backend.dto.PlacementDto;
import com.znz.tpip_backend.repository.PlacementRepository;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    public List<PlacementDto> getAllPlacements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPlacements'");
    }

    public PlacementDto getPlacementById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlacementById'");
    }

    public PlacementDto addPlacement(PlacementDto placementDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPlacement'");
    }

    public PlacementDto editPlacement(Long id, PlacementDto placementDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editPlacement'");
    }

    public void deletePlacement(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePlacement'");
    }
}
