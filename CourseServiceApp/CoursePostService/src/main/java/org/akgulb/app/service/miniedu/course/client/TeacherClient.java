package org.akgulb.app.service.miniedu.course.client;

import org.akgulb.app.service.miniedu.course.dto.TeacherExistsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "teacher-service", url = "${teacher.service.url}")
public interface TeacherClient {
    @GetMapping("/api/read/teachers/{id}/exists")
    TeacherExistsDTO existsById(@PathVariable("id") int teacherId);
}
