package com.example.yqg_backend.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderitemId implements Serializable {
    private static final long serialVersionUID = -5602090082715981089L;
    @Column(name = "orderId", nullable = false)
    private Integer orderId;

    @Column(name = "goodsId", nullable = false)
    private Integer goodsId;

    public OrderitemId() {
    }

    public OrderitemId(Integer orderId, Integer goodsId) {
        this.orderId = orderId;
        this.goodsId = goodsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderitemId entity = (OrderitemId) o;
        return Objects.equals(this.orderId, entity.orderId) &&
                Objects.equals(this.goodsId, entity.goodsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, goodsId);
    }

}