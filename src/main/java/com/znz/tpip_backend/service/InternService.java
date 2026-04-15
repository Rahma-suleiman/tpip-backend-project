package com.znz.tpip_backend.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znz.tpip_backend.dto.InternDto;
import com.znz.tpip_backend.model.Intern;
import com.znz.tpip_backend.repository.InternRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InternService {

    private final InternRepository internRepository;
    private final ModelMapper modelMapper;


    public List<InternDto> getAllInterns() {
        List<Intern> interns = internRepository.findAll();
        return modelMapper.map(interns, InternDto.class);
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
