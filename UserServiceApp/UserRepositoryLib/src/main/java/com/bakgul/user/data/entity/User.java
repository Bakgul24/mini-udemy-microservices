package com.bakgul.user.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String firstName;

    @Column(name = "middle_name", length = 100)
    private String middleName;

    @Column(name = "last_name"  ,length = 100, nullable = false)
    private String lastName;

    @Email
    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @Column(length = 256, nullable = false)
    private String password;

    @Column(name = "register_date", nullable = false)
    private LocalDate registerDate = LocalDate.now();
}
