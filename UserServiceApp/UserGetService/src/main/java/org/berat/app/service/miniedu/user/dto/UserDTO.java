package org.berat.app.service.miniedu.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class UserDTO {
        public int id;
        public String firstName;
        public String middleName;
        public String lastName;
        public String email;
        @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
        public LocalDate registerDate;
}
