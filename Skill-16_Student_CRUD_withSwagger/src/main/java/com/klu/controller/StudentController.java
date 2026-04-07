package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @Operation(summary = "Create a new student")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Student created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student){
        return service.createStudent(student);
    }

    @Operation(summary = "Get all students")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Students fetched successfully"),
        @ApiResponse(responseCode = "500", description = "Server error")
    })
    @GetMapping("/getall")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @Operation(summary = "Get student by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Student found"),
        @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/getid/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @Operation(summary = "Update student details")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Student updated successfully"),
        @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @Operation(summary = "Delete student by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Student deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @DeleteMapping("/del/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }

    @Operation(summary = "Search students by name and course")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Search results fetched"),
        @ApiResponse(responseCode = "400", description = "Invalid parameters")
    })
    @GetMapping("/search")
    public List<Student> searchStudent(@RequestParam String name,@RequestParam String course){
        return service.searchStudent(name, course);
    }
}