package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "orderId")
    private int orderId;
    @Basic
    @Column(name = "logisticsType")
    private Integer logisticsType;
    @Basic
    @Column(name = "deliverAddr")
    private String deliverAddr;
    @Basic
    @Column(name = "receiveAddr")
    private String receiveAddr;
    @Basic
    @Column(name = "note")
    private String note;
    @Basic
    @Column(name = "count")
    private Integer count;
    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "number")
    private Integer number;
    @Basic
    @Column(name = "time")
    private Timestamp time;
    @Basic
    @Column(name = "userId")
    private Integer userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="orderId")
    private List<OrderItem> orderItems;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public String getDeliverAddr() {
        return deliverAddr;
    }

    public void setDeliverAddr(String deliverAddr) {
        this.deliverAddr = deliverAddr;
    }

    public String getReceiveAddr() {
        return receiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderId == orders.orderId && Objects.equals(logisticsType, orders.logisticsType) && Objects.equals(deliverAddr, orders.deliverAddr) && Objects.equals(receiveAddr, orders.receiveAddr) && Objects.equals(note, orders.note) && Objects.equals(count, orders.count) && Objects.equals(price, orders.price) && Objects.equals(number, orders.number) && Objects.equals(time, orders.time) && Objects.equals(userId, orders.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, logisticsType, deliverAddr, receiveAddr, note, count, price, number, time, userId);
    }
}
