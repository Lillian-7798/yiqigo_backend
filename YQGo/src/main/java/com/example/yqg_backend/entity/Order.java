package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
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
    private Instant time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupBuyId")
    private Groupbuy groupBuy;

    @OneToMany(mappedBy = "order")
    private Set<Orderitem> orderitems = new LinkedHashSet<>();

    public Set<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(Set<Orderitem> orderitems) {
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

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
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