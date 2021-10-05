package com.m2i.hotel.entities;


import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;


@Entity
@Table(name = "admin", schema = "hotelm2i", catalog = "")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false, unique = true)
    private String username;

    @Column(length = 45, nullable = false, unique = true)
    private String password;

    @Column(length = 45, nullable = false, unique = true)
    private String role;

    public AdminEntity() {
    }

    public AdminEntity(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return username;
    }

}


