package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "goods")
public class Good {
    @Id
    @Column(name = "goodsId", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "images", length = 50)
    private String images;

    @OneToMany(mappedBy = "goods")
    private List<Orderitem> orderitems = new ArrayList();

    @OneToMany(mappedBy = "goods")
    private List<Groupbuyitem> groupbuyitems = new ArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public List<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    public List<Groupbuyitem> getGroupbuyitems() {
        return groupbuyitems;
    }

    public void setGroupbuyitems(List<Groupbuyitem> groupbuyitems) {
        this.groupbuyitems = groupbuyitems;
    }

}