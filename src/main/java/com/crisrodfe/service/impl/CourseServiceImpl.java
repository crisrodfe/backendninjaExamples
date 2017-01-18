package com.crisrodfe.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.crisrodfe.entity.Course;
import com.crisrodfe.repository.CourseJpaRepository;
import com.crisrodfe.service.CourseService;

@Service("courseServiceImp")
public class CourseServiceImpl implements CourseService
{
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> listAllCourses() 
	{
		LOG.info("Call: listAllCourses()");
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) 
	{
		LOG.info("Call: addCourse()");
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) 
	{
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course)
	{
		//Sobreescribe el Course si ya existe en la base de datos
		return courseJpaRepository.save(course);		
	}

}
