package com.klu.service;



import com.klu.model.User;

public interface UserService {
    User register(User user);
    User login(User user);
    User getUserById(Long id);
}