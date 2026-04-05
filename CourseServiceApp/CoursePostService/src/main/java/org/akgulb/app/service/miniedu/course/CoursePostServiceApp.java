package org.akgulb.app.service.miniedu.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@ComponentScan({"org.akgulb", "com.beratak"})
@EnableJpaRepositories(basePackages = {"org.akgulb", "com.beratak"})
@EntityScan({"org.akgulb", "com.beratak"})
public class CoursePostServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(CoursePostServiceApp.class, args);
	}

}
