package com.metropolitan.it355pz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 40)
    private String username;

    @Column(name = "password", nullable = false, length = 40)
    private String password;

    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Column(name = "role", nullable = false, length = 30)
    private String role;

    @Column(name = "enabled")
    private Boolean enabled;

}