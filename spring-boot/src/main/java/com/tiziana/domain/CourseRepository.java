package com.tiziana.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	public List<Course> findByTopicId(String topicId);
	public List<Course> findCoursesByName(String name);
	public List<Course> findCoursesByDescription(String description);
}
