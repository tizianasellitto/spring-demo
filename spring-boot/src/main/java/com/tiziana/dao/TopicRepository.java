package com.tiziana.dao;

import org.springframework.data.repository.CrudRepository;

import com.tiziana.beans.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>{

}
