package org.berat.app.service.miniedu.user.controller;

import com.bakgul.user.data.entity.dto.UserSaveDTO;
import org.berat.app.service.miniedu.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/update/users")
public class UserController {
    private final UserService m_userService;

    public UserController(UserService userService) {
        m_userService = userService;
    }

    @PostMapping("user/save")
    public ResponseEntity<UserSaveDTO> save(@RequestBody UserSaveDTO userSaveDTO) {
        var user = m_userService.saveUser(userSaveDTO);

        return user.getId() != 0 ? ResponseEntity.ok(user) : ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
    }
}
