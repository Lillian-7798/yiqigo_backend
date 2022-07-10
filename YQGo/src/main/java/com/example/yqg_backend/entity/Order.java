package com.example.yqg_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties({"user", "groupBuy"})
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false)
    private Integer id;

    @Column(name = "logisticsType")
    private Integer logisticsType;

    @Column(name = "deliverAddr", length = 50)
    private String deliverAddr;

    @Column(name = "receiveAddr", length = 50)
    private String receiveAddr;

    @Column(name = "note", length = 100)
    private String note;

    @Column(name = "count")
    private Integer count;

    @Column(name = "price")
    private Integer price;

    @Column(name = "number")
    private Integer number;

    @Column(name = "time")
    private Timestamp time;

// status=0 ----- 已支付
// status=1 ----- 运输中
// status=2 ----- 已提货
// status=3 ----- 已退款
    @Column(name = "status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupBuyId")
    private Groupbuy groupBuy;

    @OneToMany(mappedBy = "order")
    private List<Orderitem> orderitems;

    public Order() {

    }

    public Order(Integer logisticsType, String note) {
        this.logisticsType = logisticsType;
        this.note = note;
    }

    public List<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    public Groupbuy getGroupBuy() {
        return groupBuy;
    }

    public void setGroupBuy(Groupbuy groupBuy) {
        this.groupBuy = groupBuy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

    public String getReceiveAddr() {
        return receiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }

    public String getDeliverAddr() {
        return deliverAddr;
    }

    public void setDeliverAddr(String deliverAddr) {
        this.deliverAddr = deliverAddr;
    }

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//TODO [JPA Buddy] generate columns from DB
}