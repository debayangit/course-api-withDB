package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.debayan.learning1.springboottutorial1.controllers", 
		"com.debayan.learning1.springboottutorial1.services"})
@EntityScan("com.debayan.learning1.springboottutorial1.beans")
@EnableJpaRepositories("com.debayan.learning1.springboottutorial1.dao")
public class CourseApiDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiDataApplication.class, args);
	}

}

