package com.tiziana.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiziana.beans.Course;
import com.tiziana.dao.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository repository;
	
	public List<Course> getAllCourses(String id) {
		List<Course> courses = new ArrayList<>();
		repository.findByTopicId(id).forEach(courses::add);
		//repository.findAll().forEach(courses::add);
		return courses;
	}

	public Course getCourse(String id) {
		return repository.findById(id).get();
	}

	public void addCourse(Course course) {
		repository.save(course);
	}

	public void updateCourse(Course course) {
		repository.save(course);
	}

	public void deleteCourse(String id) {
		repository.deleteById(id);
	}
}
