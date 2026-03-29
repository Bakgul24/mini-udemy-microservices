package com.akgul.app.miniedu.teacher.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@ComponentScan(basePackages = {"org.akgul", "com.akgulberat","com.akgul.app.miniedu.teacher.consumer"})
@EnableJpaRepositories(basePackages = {"org.akgul", "com.akgulberat","com.akgul.app.miniedu.teacher.consumer"})
@EntityScan(basePackages = {"org.akgul", "com.akgulberat","com.akgul.app.miniedu.teacher.consumer"})
public class TeacherConsumerServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(TeacherConsumerServiceApp.class, args);
	}
}
