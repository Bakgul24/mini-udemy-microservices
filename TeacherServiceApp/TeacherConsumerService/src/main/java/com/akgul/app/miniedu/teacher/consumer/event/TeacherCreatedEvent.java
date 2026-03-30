package com.akgul.app.miniedu.teacher.consumer.event;

import java.time.LocalDate;

public class TeacherCreatedEvent {
    private int userId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    private LocalDate registerDate;
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

}
