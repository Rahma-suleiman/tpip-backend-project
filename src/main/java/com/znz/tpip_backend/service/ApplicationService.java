package com.znz.tpip_backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.*;

import com.znz.tpip_backend.dto.ApplicationDto;
import com.znz.tpip_backend.enums.ApplicationStatus;
import com.znz.tpip_backend.enums.InternStatus;
import com.znz.tpip_backend.model.Application;
import com.znz.tpip_backend.model.Intern;
import com.znz.tpip_backend.model.User;
import com.znz.tpip_backend.repository.ApplicationRepository;
import com.znz.tpip_backend.repository.InternRepository;
import com.znz.tpip_backend.repository.UserRepository;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;
    private UserRepository userRepository;
    private InternRepository internRepository;
    private ModelMapper modelMapper;

    public ApplicationService(ApplicationRepository applicationRepository, UserRepository userRepository,
            ModelMapper modelMapper) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<ApplicationDto> getAllApplications() {
        List<Application> applications = applicationRepository.findAll();
        return applications.stream()
                .map(app -> {
                    ApplicationDto appDto = modelMapper.map(app, ApplicationDto.class);
                    // private Long userId;
                    // FK
                    if (app.getUser() != null) {
                        appDto.setUserId(app.getUser().getId());
                    }
                    return appDto;
                }).collect(Collectors.toList());
    }

    public ApplicationDto getApplicationById(Long id) {
        Application app = applicationRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Application not found with id" + id));

        ApplicationDto appDto = modelMapper.map(app, ApplicationDto.class);
        // FK
        if (app.getUser() != null) {
            appDto.setUserId(app.getUser().getId());
        }
        return appDto;
    }

    public ApplicationDto addApplication(ApplicationDto applicationDto) {

        // Validate user
        if (applicationDto.getUserId() == null) {
            throw new IllegalStateException("User is required for every application");

        }
        User user = userRepository.findById(applicationDto.getUserId())
                .orElseThrow(() -> new IllegalStateException("user not found with id" + applicationDto.getUserId()));

        // prevent duplicate pending applications for the same user
        boolean hasPendingApplication = applicationRepository.existsByUserIdAndStatus(user.getId(),
                ApplicationStatus.PENDING);

        if (hasPendingApplication) {
            throw new IllegalStateException("User already has pending application");
        }

        Application app = modelMapper.map(applicationDto, Application.class);

        app.setUser(user);

        app.setStatus(ApplicationStatus.PENDING);

        app.setApplicationDate(LocalDate.now());

        // clear admin review fields-since not yet reviewed
        app.setReviewDate(null);
        app.setReviewedBy(null);

        Application savedApp = applicationRepository.save(app);

        ApplicationDto appResponse = modelMapper.map(savedApp, ApplicationDto.class);

        appResponse.setUserId(savedApp.getUser() != null ? savedApp.getUser().getId() : null);

        return appResponse;

    }
    // Why This Matches Your TPIP Flow
    // TPIP Step Now Handled
    // User submits application ✅ addApplication()
    // Status starts as pending ✅ ApplicationStatus.PENDING
    // Admin reviews later ✅ reviewedBy, reviewDate untouched
    // Prevent multiple applications ✅ check added
    // Track submission date ✅ applicationDate

    public ApplicationDto editApplication(Long id, ApplicationDto applicationDto) {

        Application existingApp = applicationRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Application not found with id" + id));

        if (existingApp.getStatus() != ApplicationStatus.PENDING) {
            throw new IllegalStateException("Only pending application can be edited");
        }

        applicationDto.setId(existingApp.getId());
        applicationDto.setStatus(existingApp.getStatus());

        applicationDto.setReviewDate(existingApp.getReviewDate());
        applicationDto.setReviewedBy(existingApp.getReviewedBy());

        modelMapper.map(applicationDto, existingApp);

        // update user if provided
        if (applicationDto.getUserId() != null) {
            User user = userRepository.findById(applicationDto.getUserId())
                    .orElseThrow(() -> new IllegalStateException("Invalid user id" + applicationDto.getUserId()));
            existingApp.setUser(user);
        }
        Application updatedApp = applicationRepository.save(existingApp);

        ApplicationDto appResponse = modelMapper.map(updatedApp, ApplicationDto.class);

        appResponse.setUserId(updatedApp.getUser() != null ? updatedApp.getUser().getId() : null);

        return appResponse;
    }

    // Now It Matches TPIP Flow
    // Rule Status
    // User edits before review ✅ Allowed
    // (You should NOT allow editing if:APPROVED n REJECTED), After admin review →
    // Approved/Rejected → no normal editing
    // User edits after approval ❌ Blocked
    // User edits after rejection ❌ Blocked
    // Admin fields protected ✅ Yes
    // Status protected ✅ Yes
    public void deleteApplication(Long id) {
        Application app = applicationRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Application not found with id " + id));

        applicationRepository.delete(app);
    }

    // public ApplicationDto reviewApplication(Long id, ApplicationStatus status, String reviewerName) {

    //     // 1. Find application
    //     Application app = applicationRepository.findById(id)
    //             .orElseThrow(() -> new IllegalStateException("Application not found with id " + id));

    //     // 2. Prevent re-review of already processed applications
    //     if (app.getStatus() != ApplicationStatus.PENDING) {
    //         throw new IllegalStateException("Application already reviewed");
    //     }

    //     // 3. Update review info
    //     app.setStatus(status);
    //     app.setReviewedBy(reviewerName);
    //     app.setReviewDate(LocalDate.now());

    //     Application updatedApp = applicationRepository.save(app);

    //     // 4. IF APPROVED → create intern
    //     if (status == ApplicationStatus.APPROVED) {

    //         Intern intern = new Intern();
    //         // intern.setUser(app.getUser());
    //         // intern.setApplication(app);
    //         intern.setStatus(InternStatus.ACTIVE);
    //         intern.setStartDate(LocalDate.now());
    //         intern.setEducationLevel(updatedApp.getEducationLevel());
    //         intern.setStatus(InternStatus.ACTIVE);
    //         // intern.setSpecialization(updatedApp.getS);
    //         intern.setStatus();
    //         intern.setStatus();
    //         intern.setStatus();

    //         // TODO: assign school + mentor (later step in flow)
    //         internRepository.save(intern);
    //     }

//         // 5. IF REJECTED → allow re-application (handled by logic in addApplication)
//         // nothing extra needed here

//         // 6. Return DTO
//         ApplicationDto dto = modelMapper.map(updatedApp, ApplicationDto.class);
//         dto.setUserId(app.getUser().getId());

//         return dto;
//     }

// }
