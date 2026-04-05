package org.akgulb.app.service.miniedu.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.akgulb", "com.beratak"})
@EnableJpaRepositories(basePackages = {"org.akgulb", "com.beratak"})
@EntityScan(basePackages = {"org.akgulb", "com.beratak"})
public class CourseGetServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(CourseGetServiceApp.class, args);
	}

}
