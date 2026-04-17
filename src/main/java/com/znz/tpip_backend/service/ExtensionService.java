package com.znz.tpip_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znz.tpip_backend.dto.ExtensionDto;
import com.znz.tpip_backend.repository.ExtensionRepository;

@Service
public class ExtensionService {
    
    @Autowired
    private ExtensionRepository extensionRepository;

    public List<ExtensionDto> getAllExtensions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllExtensions'");
    }

    public ExtensionDto getExtensionById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExtensionById'");
    }

    public ExtensionDto addExtension(ExtensionDto extensionDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addExtension'");
    }

    public ExtensionDto editExtension(Long id, ExtensionDto extensionDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editExtension'");
    }

    public void deleteExtension(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteExtension'");
    }
}
