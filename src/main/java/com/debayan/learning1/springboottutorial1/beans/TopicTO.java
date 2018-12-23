package com.debayan.learning1.springboottutorial1.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class TopicTO {
	
	private String topicId;
	private String name;
	private String description;
	
	List<CourseTO> courses;
	
	public TopicTO() {
		super();
	}
	
	
	public TopicTO(String topicId, String name, String description) {
		super();
		this.topicId = topicId;
		this.name = name;
		this.description = description;
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public List<CourseTO> getCourses() {
		return courses;
	}


	public void setCourses(List<CourseTO> courses) {
		this.courses = courses;
	}
	
	

}
