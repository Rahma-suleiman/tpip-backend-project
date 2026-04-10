package com.znz.tpip_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znz.tpip_backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
}
