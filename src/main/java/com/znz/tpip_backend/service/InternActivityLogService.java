package com.znz.tpip_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znz.tpip_backend.dto.InternActivityLogDto;
import com.znz.tpip_backend.repository.InternActivityLogRepository;

@Service
public class InternActivityLogService {
    
    @Autowired
    private InternActivityLogRepository internActivityLogRepository;

    public List<InternActivityLogDto> getAllActivityLogs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllActivityLogs'");
    }

    public InternActivityLogDto getActivityLogById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActivityLogById'");
    }

    public InternActivityLogDto addActivityLog(InternActivityLogDto internActivityLogDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addActivityLog'");
    }

    public InternActivityLogDto editActivityLog(Long id, InternActivityLogDto internActivityLogDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editActivityLog'");
    }

    public void deleteActivityLog(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteActivityLog'");
    }
}
