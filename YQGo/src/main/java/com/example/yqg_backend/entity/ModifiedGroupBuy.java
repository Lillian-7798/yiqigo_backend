package com.example.yqg_backend.entity;

import java.sql.Timestamp;
import java.util.List;

public class ModifiedGroupBuy {
    private String title;
    private String description;
    private Integer logisticsType;
    private String startTime;
    private String endTime;
    private Integer groupBuyId;
    private List<ModifiedGoods> goodList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getGroupBuyId() {
        return groupBuyId;
    }

    public void setGroupBuyId(Integer groupBuyId) {
        this.groupBuyId = groupBuyId;
    }

    public List<ModifiedGoods> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<ModifiedGoods> goodList) {
        this.goodList = goodList;
    }
}
