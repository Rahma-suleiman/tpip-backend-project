package com.znz.tpip_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.znz.tpip_backend.dto.PlacementDto;
import com.znz.tpip_backend.service.PlacementService;

@RestController
@RequestMapping("/api/v1/tpip/placement")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @GetMapping
    public ResponseEntity<List<PlacementDto>> getAllPlacements() {
        List<PlacementDto> placements = placementService.getAllPlacements();
        return new ResponseEntity<>(placements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlacementDto> getPlacementById(@PathVariable Long id) {
        PlacementDto placement = placementService.getPlacementById(id);
        return ResponseEntity.ok(placement);
    }

    @PostMapping
    public ResponseEntity<PlacementDto> addPlacement(@RequestBody PlacementDto placementDto) {
        PlacementDto placement = placementService.addPlacement(placementDto);
        return new ResponseEntity<>(placement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlacementDto> editPlacement(@PathVariable Long id,
            @RequestBody PlacementDto placementDto) {
        PlacementDto placement = placementService.editPlacement(id, placementDto);
        return new ResponseEntity<>(placement, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlacement(@PathVariable Long id) {
        placementService.deletePlacement(id);
        return ResponseEntity.noContent().build();
    }

}
