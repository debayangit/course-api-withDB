package com.debayan.learning1.springboottutorial1.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "TIPIC_")
public class Topic {
	
	@Id
	@Column(name="topicId")
	private String topicId;
	private String name;
	private String description;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "topic", cascade = { CascadeType.ALL })
	@JsonIgnore
	List<Course> courses;
	
	public Topic() {
		super();
	}
	
	
	public Topic(String topicId, String name, String description) {
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


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	

}
