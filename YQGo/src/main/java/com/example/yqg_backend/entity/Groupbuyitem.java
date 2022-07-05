package com.example.yqg_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "groupbuyitem")
@JsonIgnoreProperties({"groupBuy"})
public class Groupbuyitem {
    @EmbeddedId
    private GroupbuyitemId id;

    @MapsId("groupBuyId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "groupBuyId", nullable = false)
    private Groupbuy groupBuy;

    @MapsId("goodsId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "goodsId", nullable = false)
    private Good goods;

    @Column(name = "inventory")
    private Integer inventory;

    @Column(name = "cost")
    private Integer cost;

    public GroupbuyitemId getId() {
        return id;
    }

    public void setId(GroupbuyitemId id) {
        this.id = id;
    }

    public Groupbuy getGroupBuy() {
        return groupBuy;
    }

    public void setGroupBuy(Groupbuy groupBuy) {
        this.groupBuy = groupBuy;
    }

    public Good getGoods() {
        return goods;
    }

    public void setGoods(Good goods) {
        this.goods = goods;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

}