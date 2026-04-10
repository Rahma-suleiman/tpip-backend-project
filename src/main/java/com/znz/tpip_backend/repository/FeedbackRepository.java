package com.znz.tpip_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.znz.tpip_backend.model.Certificate;


public interface FeedbackRepository extends JpaRepository<Certificate, Long> {

    
} 


