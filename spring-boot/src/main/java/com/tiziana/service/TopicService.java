package com.tiziana.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiziana.domain.Topic;
import com.tiziana.domain.TopicRepository;

@Service
public class TopicService {
	@Autowired
	private TopicRepository repository;
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		repository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return repository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		repository.save(topic);
		
	}

	public void updateTopic(Topic topic) {
		repository.save(topic);
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		repository.deleteById(id);
	}
}
