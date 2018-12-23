package com.debayan.learning1.springboottutorial1.controllers;

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
import com.debayan.learning1.springboottutorial1.services.CourseService;

@RestController
public class CourseContorller {
	private final Logger logger =LoggerFactory.getLogger(CourseContorller.class);

	@Autowired
	private CourseService ts;

	@RequestMapping("/courses")
	public List<Course> getCourses() {	
		logger.info("logging details");
		return ts.getCourses();
	}

	@RequestMapping("/courses/{foo}")
	public Course getCourse(@PathVariable("foo") String id) {
		return ts.getCourse(id);
	}

	@RequestMapping(method= RequestMethod.POST, value= "/courses")
	public List<Course> addCourse(@RequestBody Course t){
		return ts.addCourse(t);
	}

		
	@RequestMapping(method= RequestMethod.PUT, value= "/courses/{foo}")
	public List<Course> updateCourse(@RequestBody Course t, @PathVariable("foo")String id){
		return ts.updateCourse(t, id);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value= "/courses/{foo}")
	public List<Course> deleteCourse( @PathVariable("foo")String id){
		return ts.deleteCourse( id);
	}
	
	@RequestMapping("/courses/name/{foo}")
	public List<Course> getCourseByName(@PathVariable("foo") String name) {
		return ts.getCourseByName(name);
	}

}


