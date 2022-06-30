package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userId")
    private int userId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "orderId")
    private int orderId;
    @Basic
    @Column(name = "count")
    private Integer count;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return userId == orderItem.userId && orderId == orderItem.orderId && Objects.equals(count, orderItem.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, orderId, count);
    }
}
