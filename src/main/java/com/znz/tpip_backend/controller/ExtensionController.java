package com.znz.tpip_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.znz.tpip_backend.dto.ExtensionDto;
import com.znz.tpip_backend.service.ExtensionService;

@RestController
@RequestMapping("/api/v1/tpip/extension")
public class ExtensionController {

    @Autowired
    private ExtensionService extensionService;

    @GetMapping
    public ResponseEntity<List<ExtensionDto>> getAllExtensions() {
        List<ExtensionDto> extensions = extensionService.getAllExtensions();
        return new ResponseEntity<>(extensions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtensionDto> getExtensionById(@PathVariable Long id) {
        ExtensionDto ext = extensionService.getExtensionById(id);
        return ResponseEntity.ok(ext);
    }

    @PostMapping
    public ResponseEntity<ExtensionDto> addExtension(@RequestBody ExtensionDto extensionDto) {
        ExtensionDto extension = extensionService.addExtension(extensionDto);
        return new ResponseEntity<>(extension, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExtensionDto> editExtension(@PathVariable Long id, @RequestBody ExtensionDto extensionDto) {
        ExtensionDto extension = extensionService.editExtension(id, extensionDto);
        return new ResponseEntity<>(extension, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExtension(@PathVariable Long id) {
        extensionService.deleteExtension(id);
        return ResponseEntity.noContent().build();
    }
}
