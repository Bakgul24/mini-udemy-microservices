package org.berat.app.service.miniedu.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.berat", "com.bakgul"})
@EnableJpaRepositories(basePackages = {"org.berat", "com.bakgul"})
@EntityScan(basePackages = {"org.berat", "com.bakgul"})
public class UserGetServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(UserGetServiceApp.class, args);
	}
}
