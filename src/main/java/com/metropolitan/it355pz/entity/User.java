package com.metropolitan.it355pz.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
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