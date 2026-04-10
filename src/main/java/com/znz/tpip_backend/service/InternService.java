package com.znz.tpip_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znz.tpip_backend.dto.InternDto;
import com.znz.tpip_backend.repository.InternRepository;

@Service
public class InternService {

    @Autowired
    private InternRepository internRepository;

    public List<InternDto> getAllInterns() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllInterns'");
    }

    public InternDto getInternById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInternById'");
    }

    public InternDto addIntern(InternDto internDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addIntern'");
    }

    public InternDto editIntern(Long id, InternDto internDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editIntern'");
    }

    public void deleteIntern(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteIntern'");
    }

}
