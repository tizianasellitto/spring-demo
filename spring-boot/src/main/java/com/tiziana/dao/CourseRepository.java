package com.tiziana.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tiziana.beans.Course;

public interface CourseRepository extends CrudRepository<Course, String>{
	public List<Course> findByTopicId(String topicId);
	public List<Course> findCoursesByName(String name);
	public List<Course> findCoursesByDescription(String description);
}
