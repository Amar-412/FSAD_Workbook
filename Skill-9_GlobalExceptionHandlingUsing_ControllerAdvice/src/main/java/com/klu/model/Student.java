package com.klu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String course;
	private int age;

	
	 public Student() {}
	    
	    public Student(/*Long id,*/String name,String course,int age) {
	    	//this.id=id;
	    	this.age=age;
	    	this.course=course;
	    	this.name=name;
	    }
	   
	    /*
	    public void setId(Long id) {
	    	this.id=id;
	    }
	    */
	    public Long getId() {
	    	return id;
	    }
	    public void setName(String name) {
	    	this.name=name;
	    }
	    public String getName() {
	    	return name;
	    }
	    public void setCourse(String course) {
	    	this.course=course;
	    }
	    public String getCourse() {
	    	return course;
	    }
	    public void setAge(int age) {
	    	this.age=age;
	    }
	    public int getAge() {
	    	return age;
	    }
}
