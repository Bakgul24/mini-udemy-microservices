package org.berat.app.service.miniedu.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class UserDTO {
        private long id;
        private String firstName;
        private String middleName;
        private String lastName;
        private String email;
        @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
        private LocalDate registerDate;
}
