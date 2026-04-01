package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Student;
import com.klu.repo.StudentRepo;


@Service
public class StudentService {
	 @Autowired
	    private StudentRepo studentRepo;

	    public Student createStudent(Student student) {
	        return studentRepo.save(student);
	    }

	   
	    public Student getStudentById(int id) {
	        return studentRepo.findById(id).orElse(null);
	    }

	
	    public List<Student> getAllStudents() {
	        return studentRepo.findAll();
	    }
	
	    public Student updateStudent(int id, Student student) {
	        if (studentRepo.existsById(id)) {
	            student.setId(id);
	            return studentRepo.save(student);
	        }
	        return null;
	    }

	   
	    public String deleteStudent(int id) {
	        if (studentRepo.existsById(id)) {
	            studentRepo.deleteById(id);
	            return "Student deleted successfully";
	        }
	        return "Student not found";
	    }

	    public List<Student> searchStudent(String name, String course) {
	        return studentRepo.findByNameIgnoreCaseAndCourseIgnoreCase(name, course);
	    }

}
