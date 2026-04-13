package com.znz.tpip_backend.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znz.tpip_backend.dto.InternDto;
import com.znz.tpip_backend.dto.PlacementDto;
import com.znz.tpip_backend.enums.PlacementStatus;
import com.znz.tpip_backend.model.Intern;
import com.znz.tpip_backend.model.Mentor;
import com.znz.tpip_backend.model.Placement;
import com.znz.tpip_backend.model.School;
import com.znz.tpip_backend.repository.InternRepository;
import com.znz.tpip_backend.repository.MentorRepository;
import com.znz.tpip_backend.repository.PlacementRepository;
import com.znz.tpip_backend.repository.SchoolRepository;

@Service
public class PlacementService {

    // @Autowired
    private PlacementRepository placementRepository;
    private InternRepository internRepository;
    private SchoolRepository schoolRepository;
    private MentorRepository mentorRepository;
    private ModelMapper modelMapper;

    public PlacementService(PlacementRepository placementRepository, InternRepository internRepository,
            SchoolRepository schoolRepository, MentorRepository mentorRepository, ModelMapper modelMapper) {
        this.placementRepository = placementRepository;
        this.internRepository = internRepository;
        this.schoolRepository = schoolRepository;
        this.mentorRepository = mentorRepository;
        this.modelMapper = modelMapper;
    }

    public List<PlacementDto> getAllPlacements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPlacements'");
    }

    public PlacementDto getPlacementById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlacementById'");
    }

    // public PlacementDto addPlacement(PlacementDto placementDto) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'addPlacement'");
    // }

    // public PlacementDto editPlacement(Long id, PlacementDto placementDto) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'editPlacement'");
    // }

    public InternDto assignIntern(Long id, Long schoolId, Long mentorId) {
        Intern intern = internRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("intern not found with id" + id));
        School schl = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new IllegalStateException("school not found with id" + schoolId));
        Mentor mentor = mentorRepository.findById(mentorId)
                .orElseThrow(() -> new IllegalStateException("mentor not found with id" + mentorId));

        Placement placement = new Placement();
        placement.setIntern(intern);
        placement.setSchool(schl);
        placement.setMentor(mentor);
        // Assigned but not started yet
        placement.setStatus(PlacementStatus.ASSIGNED);

        placement.setAssignedDate(LocalDate.now());

        // after assigned when shld intern start internship
        // BEST PRACTICE: internship starts later (NOT now)
        placement.setStartDate(null);
        placement.setEndDate(null);

        placementRepository.save(placement);

        return modelMapper.map(intern, InternDto.class);

    }

    public PlacementDto startInternship(Long id) {
        Placement placement = placementRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("placement not found with id" + id));

        if (placement.getStatus() != PlacementStatus.ASSIGNED) {
            throw new IllegalStateException("Internship already started or invalid state");
        }
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusMonths(12);

        placement.setStartDate(start);
        placement.setEndDate(end);

        Placement savedPlacement = placementRepository.save(placement);

        return modelMapper.map(savedPlacement, PlacementDto.class);

    }

    public void deletePlacement(Long id) {
        Placement placement = placementRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("placement not found with id" + id));
        placementRepository.delete(placement);
    }

}
