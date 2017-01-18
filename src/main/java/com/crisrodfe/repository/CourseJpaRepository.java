package com.crisrodfe.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisrodfe.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable>
{
	//El JPA repository tiene combinaciones con los nombres de los métodos que nos realiza querys automáticamente sin necesidad de implementación
	public abstract Course findByPrice(int price); 
	public abstract Course findByPriceAndName(int price, String name); 
	public abstract List<Course> findByNameOrderByHours(String name);
	public abstract Course findByNameOrPrice(String name, int price);
}
