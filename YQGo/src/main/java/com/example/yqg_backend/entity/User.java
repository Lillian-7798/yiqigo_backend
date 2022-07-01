package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "mobile", length = 20)
    private String mobile;

    @Column(name = "address", length = 50)
    private String address;

    @OneToMany(mappedBy = "user")
    private List<Groupbuy> groupbuys = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "userId1")
    private List<Dialog> dialogs1 = new ArrayList<>();

    @OneToMany(mappedBy = "userId2")
    private List<Dialog> dialogs2 = new ArrayList<>();

    public List<Dialog> getDialogs2() {
        return dialogs2;
    }

    public void setDialogs2(List<Dialog> dialogs2) {
        this.dialogs2 = dialogs2;
    }

    public List<Dialog> getDialogs1() {
        return dialogs1;
    }

    public void setDialogs1(List<Dialog> dialogs1) {
        this.dialogs1 = dialogs1;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Groupbuy> getGroupbuys() {
        return groupbuys;
    }

    public void setGroupbuys(List<Groupbuy> groupbuys) {
        this.groupbuys = groupbuys;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//TODO [JPA Buddy] generate columns from DB
}