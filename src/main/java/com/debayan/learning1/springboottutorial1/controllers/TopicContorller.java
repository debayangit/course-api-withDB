package com.debayan.learning1.springboottutorial1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.debayan.learning1.springboottutorial1.beans.Course;
import com.debayan.learning1.springboottutorial1.beans.CourseTO;
import com.debayan.learning1.springboottutorial1.beans.Topic;
import com.debayan.learning1.springboottutorial1.beans.TopicTO;
import com.debayan.learning1.springboottutorial1.services.TopicService;

@RestController
public class TopicContorller {
	private final Logger logger =LoggerFactory.getLogger(TopicContorller.class);

	@Autowired
	private TopicService ts;

	@RequestMapping("/topics")
	public List<TopicTO> getTopics() {	
		logger.info("logging details");
		List<Topic> tList= ts.getTopics();
		List<TopicTO> topicTOlist=  new ArrayList<TopicTO>();
		for(Topic t:tList) {
			convertTOObject(t);
		}
		return topicTOlist;
	}

	private TopicTO convertTOObject(Topic t) {
		TopicTO tTo= new TopicTO();
		tTo.setTopicId(t.getTopicId());
		tTo.setName(t.getName());
		tTo.setDescription(t.getDescription());
		
		List<CourseTO>  cTOList= new ArrayList<>();
		for(Course c: t.getCourses()) {
			CourseTO cTO= new CourseTO();
			cTO.setDescription(c.getDescription());
			cTO.setId(c.getId());
			cTO.setName(c.getName());
			
			cTOList.add(cTO);
		}
		
		tTo.setCourses(cTOList);
		
		return tTo;
	}

	@RequestMapping("/topics/{foo}")
	public TopicTO getTopic(@PathVariable("foo") String id) {
	
		return convertTOObject(ts.getTopic(id));
	}

	@RequestMapping(method= RequestMethod.POST, value= "/topics")
	public List<Topic> addTopic(@RequestBody Topic t){
		return ts.addTopic(t);
	}

		
	@RequestMapping(method= RequestMethod.PUT, value= "/topics/{foo}")
	public List<Topic> updateTopic(@RequestBody Topic t, @PathVariable("foo")String id){
		return ts.updateTopic(t, id);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value= "/topics/{foo}")
	public List<Topic> deleteTopic( @PathVariable("foo")String id){
		return ts.deleteTopic( id);
	}
	
	@RequestMapping("/topics/name/{foo}")
	public List<Topic> getTopicByName(@PathVariable("foo") String name) {
		return ts.getTopicByName(name);
	}

}


