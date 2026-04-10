package com.znz.tpip_backend.service;

import java.util.List;

import org.springframework.stereotype.*;

import com.znz.tpip_backend.dto.ApplicationDto;
import com.znz.tpip_backend.repository.ApplicationRepository;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;

    public List<ApplicationDto> getAllApplications() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllApplications'");
    }

    public ApplicationDto getApplicationById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getApplicationById'");
    }

    public ApplicationDto addApplication(ApplicationDto applicationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addApplication'");
    }

    public ApplicationDto editApplication(Long id, ApplicationDto applicationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editApplication'");
    }

    public void deleteApplication(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteApplication'");
    }

}
