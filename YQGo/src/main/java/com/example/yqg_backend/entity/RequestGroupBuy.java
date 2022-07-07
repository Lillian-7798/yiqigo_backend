package com.example.yqg_backend.entity;


import java.util.List;

public class RequestGroupBuy {
    private Integer userid;
    private String title;
    private String description;
    private Integer logisticsType;
    private String startTime;
    private String endTime;
    private List<RequestGoods2> goodList;

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public Integer getUserid() {
        return userid;
    }

    public List<RequestGoods2> getGoodList() {
        return goodList;
    }

    public String getDescription() {
        return description;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setGoodList(List<RequestGoods2> goodList) {
        this.goodList = goodList;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
