package com.klu.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/add")
    public String addEmployee() {
        return "Employee Added";
    }

    @DeleteMapping("/delete")
    public String deleteEmployee() {
        return "Employee Deleted";
    }
}
