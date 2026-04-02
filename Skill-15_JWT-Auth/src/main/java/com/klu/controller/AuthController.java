package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.klu.dto.AuthRequest;
import com.klu.model.Role;
import com.klu.model.User;
import com.klu.repository.UserRepository;
import com.klu.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        	
        if (user.getRole() == null) {
            user.setRole(Role.EMPLOYEE); 
        }

        userRepository.save(user);

        return "User Registered as " + user.getRole();
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow();

        return jwtUtil.generateToken(
                user.getUsername(),
                user.getRole().name()   
        );
    }
}