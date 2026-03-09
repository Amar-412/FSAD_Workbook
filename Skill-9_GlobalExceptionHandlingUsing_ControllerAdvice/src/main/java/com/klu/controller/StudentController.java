package com.klu.controller;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Student;
import com.klu.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
    private StudentService service;

    // CREATE
    @PostMapping("/student/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(
                service.createStudent(student),
                HttpStatus.CREATED);
    }

    // READ ALL (Pagination)
    @GetMapping("/getall")
    public ResponseEntity<Page<Student>> getAllStudents(
            @RequestParam int page,
            @RequestParam int size) {

        return ResponseEntity.ok(service.getAllStudents(page, size));
    }

    // READ BY ID
    @GetMapping("/student/getbyid/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(
                service.getStudentById(id));
    }
    
 // UPDATE
    @PutMapping("/student/update/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        return ResponseEntity.ok(
                service.updateStudent(id, student));
    }

    // DELETE
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {

        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }




}



