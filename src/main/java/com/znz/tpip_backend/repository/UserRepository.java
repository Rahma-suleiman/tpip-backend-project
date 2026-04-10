package com.znz.tpip_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.znz.tpip_backend.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    
} 



