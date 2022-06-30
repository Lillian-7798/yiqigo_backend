package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class GroupBuyItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userId")
    private int userId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "groupBuyId")
    private int groupBuyId;
    @Basic
    @Column(name = "inventory")
    private Integer inventory;
    @Basic
    @Column(name = "cost")
    private Integer cost;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupBuyId() {
        return groupBuyId;
    }

    public void setGroupBuyId(int groupBuyId) {
        this.groupBuyId = groupBuyId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupBuyItem that = (GroupBuyItem) o;
        return userId == that.userId && groupBuyId == that.groupBuyId && Objects.equals(inventory, that.inventory) && Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, groupBuyId, inventory, cost);
    }
}
