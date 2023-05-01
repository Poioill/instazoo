package com.example.instazoo.service;

import com.example.instazoo.entity.Usr;
import com.example.instazoo.entity.enums.ERole;
import com.example.instazoo.exceptions.UserExistException;
import com.example.instazoo.payload.request.SignupRequest;
import com.example.instazoo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Usr createUser(SignupRequest userIn){
        Usr usr = new Usr();
        usr.setEmail(userIn.getEmail());
        usr.setName(userIn.getFirstname());
        usr.setLastname(userIn.getLastname());
        usr.setUsername(userIn.getUsername());
        usr.setPassword(passwordEncoder.encode(userIn.getPassword()));
        usr.getRole().add(ERole.ROLE_USER);

        try {
            LOG.info("Saving User {}", userIn.getEmail());
            return userRepository.save(usr);
        } catch (Exception e){
            LOG.error("Error during registration {}", e.getMessage());
            throw new UserExistException("The user " + usr.getName() + " already exist. Please check credentials");
        }
    }
}
