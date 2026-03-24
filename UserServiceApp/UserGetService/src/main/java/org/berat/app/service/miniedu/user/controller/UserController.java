package org.berat.app.service.miniedu.user.controller;

import org.berat.app.service.miniedu.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bakgul.user.data.entity.User;

import java.util.Optional;

@RestController
@RequestMapping("api/read/users")
public class UserController {
    private final UserService m_userService;

    public UserController(UserService userService) {
        m_userService = userService;
    }

    @GetMapping("/find/email")
    public Optional<User> findByEmail(@RequestParam("m") String email) {
        return m_userService.findByEmail(email);
    }
}
