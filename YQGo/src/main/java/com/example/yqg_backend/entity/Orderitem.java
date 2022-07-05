package com.example.yqg_backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "orderitem")
public class Orderitem {
    @EmbeddedId
    private OrderitemId id;

    @MapsId("orderId")
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    @MapsId("goodsId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "goodsId", nullable = false)
    private Good goods;

    @Column(name = "count")
    private Integer count;

    public Orderitem() {
    }

    public Orderitem(Good goods, Integer count) {
        this.goods = goods;
        this.count = count;
    }

    public OrderitemId getId() {
        return id;
    }

    public void setId(OrderitemId id) {
        this.id = id;
    }

    @JsonBackReference
    public Order getOrder() {
        return order;
    }

    @JsonBackReference
    public void setOrder(Order order) {
        this.order = order;
    }

    public Good getGoods() {
        return goods;
    }

    public void setGoods(Good goods) {
        this.goods = goods;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}