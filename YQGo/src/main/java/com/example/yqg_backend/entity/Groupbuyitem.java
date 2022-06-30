package com.example.yqg_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "groupbuyitem")
public class Groupbuyitem {
    @EmbeddedId
    private GroupbuyitemId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodsId")
    private Good goods;

    @MapsId("groupBuyId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "groupBuyId", nullable = false)
    private Groupbuy groupBuy;

    @Column(name = "inventory")
    private Integer inventory;

    @Column(name = "cost")
    private Integer cost;

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Groupbuy getGroupBuy() {
        return groupBuy;
    }

    public void setGroupBuy(Groupbuy groupBuy) {
        this.groupBuy = groupBuy;
    }

    public GroupbuyitemId getId() {
        return id;
    }

    public void setId(GroupbuyitemId id) {
        this.id = id;
    }

    public Good getGoods() {
        return goods;
    }

    public void setGoods(Good goods) {
        this.goods = goods;
    }

}