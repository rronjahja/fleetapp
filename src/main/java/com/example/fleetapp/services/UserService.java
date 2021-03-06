package com.example.fleetapp.services;

import com.example.fleetapp.models.User;
import com.example.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        //encode password before saving in database
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}