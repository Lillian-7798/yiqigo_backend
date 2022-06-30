package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "yiqigo", catalog = "")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userId")
    private int userId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "mobile")
    private String mobile;
    @Basic
    @Column(name = "address")
    private String address;

    @Transient
    private List<Orders> orders;

    @Transient
    private List<Dialog> dialogs;

    @Transient
    private List<Groupbuy> groupbuys;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userId == users.userId && Objects.equals(name, users.name) && Objects.equals(mobile, users.mobile) && Objects.equals(address, users.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, mobile, address);
    }
}
