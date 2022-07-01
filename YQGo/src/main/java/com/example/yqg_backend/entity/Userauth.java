package com.example.yqg_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "userauth")
public class Userauth {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Integer id;

    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "password", length = 20)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

}