package com.klu.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.model.Course;
import com.klu.service.CourseService;

@Service 
public class CourseServiceImpl implements CourseService{

	List<Course> courseList = new ArrayList<>();
	
	
	@Override
	public Course addCourse(Course course) {
		courseList.add(course);
		return course;
	}

	@Override
	public Course updateCourse(long courseId, Course course) {
		for(int i=0;i<courseList.size();i++) {
			if(courseList.get(i).getCourseId()== courseId) {
				course.setCourseId(courseId);
				courseList.set(i,course);
				return course;
			}
		}
		return null;
	}

	@Override
	public String deleteCourse(long courseId) {
		for(Course c:courseList) {
		    if(c.getCourseId() == courseId) {
		    	courseList.remove(c);
		    	return "Course deleted successfully";
		    }
	   }
		return "Course Not found!";
	}

	@Override
	public Course viewCourseById(long courseId) {
		for(Course c:courseList) {
		    if(c.getCourseId() == courseId) {
		    	return c;
		    }
	   }
		return null;
	}

	@Override
	public List<Course> viewAllCourse() {
		return courseList;
	}

	@Override
	public Course searchCourseByTitle(String Title) {
		for(Course c:courseList) {
		    if(c.getTitle().equalsIgnoreCase(Title)) {
		    	return c;
		    }
	   }
		return null;
	}

}
