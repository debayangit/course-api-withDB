package com.debayan.learning1.springboottutorial1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debayan.learning1.springboottutorial1.beans.Course;
import com.debayan.learning1.springboottutorial1.beans.Topic;
import com.debayan.learning1.springboottutorial1.dao.CourseDAOInterface;

@Service
public class CourseService {
	@Autowired
	CourseDAOInterface courseRepository;
	@Autowired
	private TopicService ts;

	
	

	 
	public List<Course> getCourses() {
		List<Course> Courses = new ArrayList<Course>();
		courseRepository.findAll().forEach(Courses::add);
		return Courses;
	}
	
	public CourseDAOInterface getCourseRepository() {
		return courseRepository;
	}

	public void setCourseRepository(CourseDAOInterface CourseRepository) {
		this.courseRepository = CourseRepository;
	}

	public Course getCourse(String id) {
		//return Courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).get();
	}
	
	public List<Course> addCourse(Course t){
		Topic top= ts.getTopic(t.getTopic().getTopicId());
		t.setTopic(top);
		courseRepository.save(t);
		return getCourses();
	}
	
	public List<Course> getCourseByName(String name) {
		//return Courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findByName(name);
	}
	
	public List<Course> updateCourse(Course t, String id){
		/*for(int i=0; i<Courses.size(); i++) {
			if(Courses.get(i).getId().equals(id)) {
				Courses.set(i, t);
			}
		}*/
		courseRepository.save(t);
		return getCourses();
	}

	public List<Course> deleteCourse(String id) {
		/*Course tDelete= Courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Courses.remove(tDelete);*/
		
		courseRepository.deleteById(id);;
		return getCourses();
	} 
}
