package com.crisrodfe.service;

import java.util.List;

import com.crisrodfe.entity.Course;
import com.crisrodfe.model.CourseModel;

public interface CourseService
{
	public abstract List<Course>listAllCourses();
	public abstract Course addCourse(CourseModel courseModel);
	public abstract int removeCourse(int id);
	public abstract Course updateCourse(CourseModel course);
	
}
