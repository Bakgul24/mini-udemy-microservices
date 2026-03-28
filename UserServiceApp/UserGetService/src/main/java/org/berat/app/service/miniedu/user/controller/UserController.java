package org.berat.app.service.miniedu.user.controller;

import com.bakgul.user.data.entity.enums.Role;
import org.berat.app.service.miniedu.user.dto.UserDTO;
import org.berat.app.service.miniedu.user.dto.UserExistsDTO;
import org.berat.app.service.miniedu.user.dto.UsersDTO;
import org.berat.app.service.miniedu.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/read/users")
public class UserController {
    private final UserService m_userService;

    public UserController(UserService userService) {
        m_userService = userService;
    }

    @GetMapping("/user/find/email")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam("m") String email) {
        return m_userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                        new com.miniedu.exception.common.ResourceNotFoundException("User", "email: " + email)
                );
    }

    @GetMapping("/user/id/exists/{id}")
    public ResponseEntity<UserExistsDTO> existsUserById(@PathVariable int id) {
        UserExistsDTO result = m_userService.existsUserById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/find/name")
    public ResponseEntity<UsersDTO> findByName(@RequestParam("n") String name) {
        UsersDTO result = m_userService.findByName(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/find/role")
    public ResponseEntity<UsersDTO> findByRole(@RequestParam("r") String roleStr) {
        try {
            Role role = Role.valueOf(roleStr.toUpperCase());
            UsersDTO result = m_userService.findByRole(role);

            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}