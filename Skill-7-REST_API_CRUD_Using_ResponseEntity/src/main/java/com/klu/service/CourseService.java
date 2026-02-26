package com.klu.service;

import java.util.List;
import com.klu.model.Course;


public interface CourseService {

	Course addCourse(Course course);
	Course updateCourse(long courseId, Course course);
	String deleteCourse(long courseId);
	Course viewCourseById(long courseId);
	List<Course> viewAllCourse();
	Course searchCourseByTitle(String Title);
}
