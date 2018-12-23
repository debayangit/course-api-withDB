package com.debayan.learning1.springboottutorial1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.debayan.learning1.springboottutorial1.beans.Topic;
import com.debayan.learning1.springboottutorial1.dao.TopicDAOInterface;

@Service
public class TopicService {
	@Autowired
	TopicDAOInterface topicRepository;
	
	/*private List<Topic> topics= new ArrayList<Topic>(Arrays.asList(
			new Topic("1", "name1", "description1"),
			new Topic("2", "name2", "description2"),
			new Topic("3", "name3", "description3")));
*/

	 
	public List<Topic> getTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public TopicDAOInterface getTopicRepository() {
		return topicRepository;
	}

	public void setTopicRepository(TopicDAOInterface topicRepository) {
		this.topicRepository = topicRepository;
	}

	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Topic tt= topicRepository.findById(id).get();
		tt.getCourses();
		return tt;
	}
	
	public List<Topic> addTopic(Topic t){
		topicRepository.save(t);
		return getTopics();
	}
	
	public List<Topic> getTopicByName(String name) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findByName(name);
	}
	
	public List<Topic> updateTopic(Topic t, String id){
		/*for(int i=0; i<topics.size(); i++) {
			if(topics.get(i).getId().equals(id)) {
				topics.set(i, t);
			}
		}*/
		topicRepository.save(t);
		return getTopics();
	}

	public List<Topic> deleteTopic(String id) {
		/*Topic tDelete= topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		topics.remove(tDelete);*/
		
		topicRepository.deleteById(id);;
		return getTopics();
	} 
}
