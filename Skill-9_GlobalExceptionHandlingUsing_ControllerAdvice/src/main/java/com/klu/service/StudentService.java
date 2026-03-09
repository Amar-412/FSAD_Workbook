package com.klu.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.exception.StudentNotFoundException;
import com.klu.model.Student;
import com.klu.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
    private StudentRepo repository;

    public Student createStudent(Student student) {
        return repository.save(student);
    }

   
    public Page<Student> getAllStudents(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));
    }
    
    public Student updateStudent(Long id, Student updatedStudent) {

        Student existing = getStudentById(id);

        existing.setName(updatedStudent.getName());
        existing.setCourse(updatedStudent.getCourse());
        existing.setAge(updatedStudent.getAge());

        return repository.save(existing);
    }


    public void deleteStudent(Long id) {

        Student student = getStudentById(id);
        repository.delete(student);
    }
    
    
}
