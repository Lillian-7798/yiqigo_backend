package com.example.yqg_backend.entity;

import java.util.List;

public class RequestOrder {
    private Integer userId;
    private Integer groupBuyId;
    private Integer logisticsType;
    private String note;

    private List<RequestGoods> goods;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupBuyId() {
        return groupBuyId;
    }

    public void setGroupBuyId(Integer groupBuyId) {
        this.groupBuyId = groupBuyId;
    }

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<RequestGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<RequestGoods> goods) {
        this.goods = goods;
    }
}
