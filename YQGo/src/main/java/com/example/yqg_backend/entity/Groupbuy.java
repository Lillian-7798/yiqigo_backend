package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "groupbuy")
public class Groupbuy {
    @Id
    @Column(name = "groupBuyId", nullable = false)
    private Integer id;

    @Column(name = "title", length = 20)
    private String title;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "logisticsType")
    private Integer logisticsType;

    @Column(name = "startTime")
    private Instant startTime;

    @Column(name = "endTime")
    private Instant endTime;

    @Column(name = "isSecKill")
    private Boolean isSecKill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "groupBuy")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "groupBuy")
    private Set<Groupbuyitem> groupbuyitems = new LinkedHashSet<>();

    public Set<Groupbuyitem> getGroupbuyitems() {
        return groupbuyitems;
    }

    public void setGroupbuyitems(Set<Groupbuyitem> groupbuyitems) {
        this.groupbuyitems = groupbuyitems;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getIsSecKill() {
        return isSecKill;
    }

    public void setIsSecKill(Boolean isSecKill) {
        this.isSecKill = isSecKill;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//TODO [JPA Buddy] generate columns from DB
}