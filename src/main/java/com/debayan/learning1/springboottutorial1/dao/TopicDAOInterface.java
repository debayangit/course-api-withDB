package com.debayan.learning1.springboottutorial1.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.debayan.learning1.springboottutorial1.beans.Topic;
public interface TopicDAOInterface extends CrudRepository<Topic,String>{

	public List<Topic> findByName(String name);
}
