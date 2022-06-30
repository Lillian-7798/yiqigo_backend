package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Groupbuy {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @javax.persistence.Column(name = "groupBuyId")
    private int groupBuyId;

    public int getGroupBuyId() {
        return groupBuyId;
    }

    public void setGroupBuyId(int groupBuyId) {
        this.groupBuyId = groupBuyId;
    }

    @Basic
    @Column(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "logisticsType")
    private Integer logisticsType;

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    @Basic
    @Column(name = "startTime")
    private Timestamp startTime;

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime")
    private Timestamp endTime;

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "isSecKill")
    private Byte isSecKill;

    public Byte getIsSecKill() {
        return isSecKill;
    }

    public void setIsSecKill(Byte isSecKill) {
        this.isSecKill = isSecKill;
    }

    @Basic
    @Column(name = "userId")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="groupBuyId")
    private List<GroupBuyItem> groupBuyItems;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groupbuy groupbuy = (Groupbuy) o;
        return groupBuyId == groupbuy.groupBuyId && Objects.equals(title, groupbuy.title) && Objects.equals(description, groupbuy.description) && Objects.equals(logisticsType, groupbuy.logisticsType) && Objects.equals(startTime, groupbuy.startTime) && Objects.equals(endTime, groupbuy.endTime) && Objects.equals(isSecKill, groupbuy.isSecKill) && Objects.equals(userId, groupbuy.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupBuyId, title, description, logisticsType, startTime, endTime, isSecKill, userId);
    }
}
