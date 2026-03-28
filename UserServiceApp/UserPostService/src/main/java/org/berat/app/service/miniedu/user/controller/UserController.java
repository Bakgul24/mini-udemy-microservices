package org.berat.app.service.miniedu.user.controller;

import com.bakgul.user.data.entity.dto.UserSaveDTO;
import org.berat.app.service.miniedu.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/update/users")
public class UserController {
    private final UserService m_userService;

    public UserController(UserService userService) {
        m_userService = userService;
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserSaveDTO> saveUser(@RequestBody UserSaveDTO userSaveDTO) {
        UserSaveDTO savedUser = m_userService.saveUser(userSaveDTO);
        System.out.print(userSaveDTO.getRole());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @DeleteMapping("/user/delete/email")
    public ResponseEntity<Void> deleteUserByEmail(@RequestParam("m") String email) {
        m_userService.deleteUserByEmail(email);

        return ResponseEntity.noContent().build();
    }
}