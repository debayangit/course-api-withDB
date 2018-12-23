package com.debayan.learning1.springboottutorial1.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.debayan.learning1.springboottutorial1.beans.Course;
import com.debayan.learning1.springboottutorial1.beans.Topic;
public interface CourseDAOInterface extends CrudRepository<Course,String>{

	public List<Course> findByName(String name);
	public Topic findByTopicTopicId(String id);
}
