package com.klu.model;

public class Course {

	private long courseId;
	private String title;
	private String duration;
	private double fee;
	
    public Course(long courseId, String title , String duration , double fee){
    	this.courseId = courseId;
    	this.title = title;
    	this.duration = duration;
    	this.fee = fee;
    }
	
    public long getCourseId() {
    	return this.courseId;
    }
    
    public void setCourseId(long courseId) {
    	this.courseId = courseId;
    }
    
    public String getTitle() {
    	return title;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getDuration() {
    	return duration;
    }
    
    public void setDuration(String duration){
    	this.duration = duration;
    }
    
    public double getFee() {
    	return fee;
    }
    
    public void setFee(double fee) {
    	this.fee = fee;
    }
}
