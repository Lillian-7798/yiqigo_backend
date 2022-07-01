package com.example.yqg_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderitem")
public class Orderitem {
    @EmbeddedId
    private OrderitemId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodsId")
    private Good goods;

    @MapsId("orderId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    @Column(name = "count")
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderitemId getId() {
        return id;
    }

    public void setId(OrderitemId id) {
        this.id = id;
    }

    public Good getGoods() {
        return goods;
    }

    public void setGoods(Good goods) {
        this.goods = goods;
    }

}