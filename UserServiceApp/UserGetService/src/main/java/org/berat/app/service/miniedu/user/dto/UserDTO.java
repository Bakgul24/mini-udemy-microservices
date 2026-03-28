package org.berat.app.service.miniedu.user.dto;

import com.bakgul.user.data.entity.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class UserDTO {
        private int id;
        private String firstName;
        private String middleName;
        private String lastName;
        private String email;

        public Role getRole() {
                return role;
        }

        public void setRole(Role role) {
                this.role = role;
        }

        private Role role;
        @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
        private LocalDate registerDate;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getMiddleName() {
                return middleName;
        }

        public void setMiddleName(String middleName) {
                this.middleName = middleName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public LocalDate getRegisterDate() {
                return registerDate;
        }

        public void setRegisterDate(LocalDate registerDate) {
                this.registerDate = registerDate;
        }
}
