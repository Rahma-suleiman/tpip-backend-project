package com.znz.tpip_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.znz.tpip_backend.dto.InternDto;
import com.znz.tpip_backend.dto.PlacementDto;
import com.znz.tpip_backend.service.PlacementService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


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

    // @PostMapping
    // public ResponseEntity<PlacementDto> addPlacement(@RequestBody PlacementDto placementDto) {
    //     PlacementDto placement = placementService.addPlacement(placementDto);
    //     return new ResponseEntity<>(placement, HttpStatus.CREATED);
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<PlacementDto> editPlacement(@PathVariable Long id,
    //         @RequestBody PlacementDto placementDto) {
    //     PlacementDto placement = placementService.editPlacement(id, placementDto);
    //     return new ResponseEntity<>(placement, HttpStatus.OK);
    // }
    @PutMapping("/interns/{id}/assign")
    public ResponseEntity<InternDto> assignIntern(@PathVariable Long id,
            @RequestParam Long schoolId, @RequestParam Long mentorId) {
        InternDto dto = placementService.assignIntern(id, schoolId,mentorId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}/start")
    public PlacementDto startInternship(@PathVariable Long id) {
        return placementService.startInternship(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlacement(@PathVariable Long id) {
        placementService.deletePlacement(id);
        return ResponseEntity.noContent().build();
    }

}
