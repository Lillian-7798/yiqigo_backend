package com.example.yqg_backend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GroupbuyitemId implements Serializable {
    private static final long serialVersionUID = -5187705943395139675L;
    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Column(name = "groupBuyId", nullable = false)
    private Integer groupBuyId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || org.springframework.data.util.ProxyUtils.getUserClass(this) != org.springframework.data.util.ProxyUtils.getUserClass(o))
            return false;
        GroupbuyitemId entity = (GroupbuyitemId) o;
        return Objects.equals(this.groupBuyId, entity.groupBuyId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupBuyId, userId);
    }

}