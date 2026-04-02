package com.klu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.User;
import com.klu.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User register(User user) {
        return repo.save(user);
    }

    @Override
    public User login(User user) {
        User existing = repo.findByUsernameAndPassword(
            user.getUsername(),
            user.getPassword()
        );

        if (existing == null) {
            throw new RuntimeException("Invalid credentials");
        }

        return existing;
    }

    @Override
    public User getUserById(Long id) {
        return repo.findById(id).orElseThrow();
    }
}
