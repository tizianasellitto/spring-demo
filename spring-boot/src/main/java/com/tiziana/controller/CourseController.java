package com.tiziana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiziana.domain.Course;
import com.tiziana.domain.Topic;
import com.tiziana.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService service;

	@RequestMapping("/topic/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return service.getAllCourses(topicId);
	}

	@RequestMapping("/topic/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id ) {
		return service.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topic/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"", ""));
		service.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		service.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		service.deleteCourse(id);
	}
}
