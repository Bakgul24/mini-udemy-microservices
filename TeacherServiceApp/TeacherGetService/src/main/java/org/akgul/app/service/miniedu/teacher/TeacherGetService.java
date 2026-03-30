package org.akgul.app.service.miniedu.teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.akgul", "com.akgulberat"})
@EnableJpaRepositories(basePackages = {"org.akgul", "com.akgulberat"})
@EntityScan(basePackages = {"org.akgul", "com.akgulberat"})
public class TeacherGetService {
    public static void main(String[] args) {
        SpringApplication.run(TeacherGetService.class, args);
    }
}
