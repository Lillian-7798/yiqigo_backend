package com.example.yqg_backend.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GroupbuyitemId implements Serializable {
    private static final long serialVersionUID = 6654422420640750383L;
    @Column(name = "groupBuyId", nullable = false)
    private Integer groupBuyId;

    @Column(name = "goodsId", nullable = false)
    private Integer goodsId;

    public GroupbuyitemId(){

    }
    public GroupbuyitemId(Integer groupBuyId,Integer goodsId){
        this.goodsId=goodsId;
        this.groupBuyId=groupBuyId;
    }

    public Integer getGroupBuyId() {
        return groupBuyId;
    }

    public void setGroupBuyId(Integer groupBuyId) {
        this.groupBuyId = groupBuyId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GroupbuyitemId entity = (GroupbuyitemId) o;
        return Objects.equals(this.goodsId, entity.goodsId) &&
                Objects.equals(this.groupBuyId, entity.groupBuyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, groupBuyId);
    }

}