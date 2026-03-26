package org.berat.app.service.miniedu.user.controller;

import org.berat.app.service.miniedu.user.dto.UserDTO;
import org.berat.app.service.miniedu.user.dto.UserExistsDTO;
import org.berat.app.service.miniedu.user.dto.UsersDTO;
import org.berat.app.service.miniedu.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/read/users")
public class UserController {
    private final UserService m_userService;

    public UserController(UserService userService) {
        m_userService = userService;
    }

    @GetMapping("/find/email")
    public Optional<UserDTO> findByEmail(@RequestParam("m") String email) {
        return m_userService.findByEmail(email);
    }

    @GetMapping("user/id/exists/{id}")
    public UserExistsDTO existsUserById(int id) {
        return m_userService.existsUserById(id);
    }

    @GetMapping("/find/name")
    public UsersDTO findByName(@RequestParam("n") String name) {
        return m_userService.findByName(name);
    }
}
