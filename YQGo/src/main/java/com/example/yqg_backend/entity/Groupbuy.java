package com.example.yqg_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groupbuy")
@JsonIgnoreProperties({"user", "orders"})
public class Groupbuy {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "groupBuyId", nullable = false)
    private Integer id;

    @Column(name = "title", length = 20)
    private String title;

    @Column(name = "description", length = 100)
    private String description;

// logisticsType=0 ----- 用户自提
// logisticsType=1 ----- 国内物流
// logisticsType=2 ----- 国际物流
    @Column(name = "logisticsType")
    private Integer logisticsType;

    @Column(name = "startTime")
    private Timestamp startTime;

    @Column(name = "endTime")
    private Timestamp endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "groupBuy")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "groupBuy")
    private List<Groupbuyitem> groupbuyitems = new ArrayList<>();

//    status=0 ----- 团购提前结束
//    status=1 ----- 团购依据时间判断是否结束
//    status=2 ----- 团购已删除
    @Column(name = "status")
    private Integer status;

    public Groupbuy(){}

    public Groupbuy(String title,String description,Integer logisticsType,Timestamp startTime,Timestamp endTime){
        this.title=title;
        this.description=description;
        this.logisticsType=logisticsType;
        this.startTime=startTime;
        this.endTime=endTime;
        this.status=1;
    }

    public List<Groupbuyitem> getGroupbuyitems() {
        return groupbuyitems;
    }

    public void setGroupbuyitems(List<Groupbuyitem> groupbuyitems) {
        this.groupbuyitems = groupbuyitems;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
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

    public Integer getStatus() {return status;}

    public void setStatus(Integer status) {this.status = status;}

//TODO [JPA Buddy] generate columns from DB
}