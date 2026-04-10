package com.znz.tpip_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.znz.tpip_backend.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    
} 
