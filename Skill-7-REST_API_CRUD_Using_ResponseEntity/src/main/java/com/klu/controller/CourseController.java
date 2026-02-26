package com.klu.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {

	@Autowired
	private CourseService service;
	
	//Create
	@PostMapping("/course/add")
	public ResponseEntity<Course> addCourse(@RequestBody Course course){
		return new ResponseEntity<>(
				service.addCourse(course),
				HttpStatus.CREATED);
	}
	
	//Update 
	@PutMapping("/course/update/{courseId}")
	public ResponseEntity<Course> updateCourse(@PathVariable long courseId, @RequestBody Course course){
		return  ResponseEntity.ok(
				service.updateCourse(courseId,course));
	}
	
	//Delete
	@DeleteMapping("/course/delete/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable long courseId){
		service.deleteCourse(courseId);
		return ResponseEntity.ok("Course Deleted Successfully");
	}
	
	@GetMapping("/course/viewall")
	public ResponseEntity<List<Course>> viewAllCourse(){
		return ResponseEntity.ok(service.viewAllCourse());
		
	}
	
	@GetMapping("/course/viewbyid/{courseId}")
	public ResponseEntity<Course> viewCourseById(@PathVariable long courseId){
		return ResponseEntity.ok(service.viewCourseById(courseId));
		
	}
	
	@GetMapping("/course/search/{title}")
	public ResponseEntity<Course> searchCourseByTitle(@PathVariable String Title){
		return ResponseEntity.ok(service.searchCourseByTitle(Title));
	}
}
