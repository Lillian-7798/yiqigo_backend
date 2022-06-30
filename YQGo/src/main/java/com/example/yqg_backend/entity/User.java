package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "userId", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "mobile", length = 20)
    private String mobile;

    @Column(name = "address", length = 50)
    private String address;

    @OneToMany(mappedBy = "user")
    private Set<Groupbuy> groupbuys = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userId1")
    private Set<Dialog> dialogs1 = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userId2")
    private Set<Dialog> dialogs2 = new LinkedHashSet<>();

    public Set<Dialog> getDialogs2() {
        return dialogs2;
    }

    public void setDialogs2(Set<Dialog> dialogs2) {
        this.dialogs2 = dialogs2;
    }

    public Set<Dialog> getDialogs1() {
        return dialogs1;
    }

    public void setDialogs1(Set<Dialog> dialogs1) {
        this.dialogs1 = dialogs1;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Groupbuy> getGroupbuys() {
        return groupbuys;
    }

    public void setGroupbuys(Set<Groupbuy> groupbuys) {
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