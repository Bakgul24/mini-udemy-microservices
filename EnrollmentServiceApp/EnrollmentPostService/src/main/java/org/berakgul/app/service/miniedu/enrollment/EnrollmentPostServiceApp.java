package org.berakgul.app.service.miniedu.enrollment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.berak", "com.berakgul"})
@EnableJpaRepositories(basePackages = {"org.berak", "com.berakgul"})
@EntityScan(basePackages = {"org.berak", "com.berakgul"})
public class EnrollmentPostServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(EnrollmentPostServiceApp.class, args);
	}

}
