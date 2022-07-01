package com.example.yqg_backend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderitemId implements Serializable {
    private static final long serialVersionUID = 2702299780197960056L;
    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Column(name = "orderId", nullable = false)
    private Integer orderId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderitemId that = (OrderitemId) o;
        return userId.equals(that.userId) && orderId.equals(that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId);
    }

}