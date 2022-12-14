package com.example.yqg_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"groupbuys", "orders", "dialogs1", "dialogs2"})
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "mobile", length = 20)
    private String mobile;

    @Column(name = "money")
    private Integer money;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "member_leader", joinColumns = {
            @JoinColumn(name = "member_id", referencedColumnName = "userId")}, inverseJoinColumns = {
            @JoinColumn(name = "leader_id", referencedColumnName = "userId")})
    private List<User> leaders = new ArrayList<>();

    @ManyToMany(mappedBy = "leaders")
    private List<User> members = new ArrayList<>();

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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setLeaders(List<User> leaders) {
        this.leaders = leaders;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<User> getLeaders() {
        return leaders;
    }


    //TODO [JPA Buddy] generate columns from DB
}