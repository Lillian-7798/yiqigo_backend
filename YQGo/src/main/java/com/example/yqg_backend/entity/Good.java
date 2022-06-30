package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
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
    private Set<Orderitem> orderitems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "goods")
    private Set<Groupbuyitem> groupbuyitems = new LinkedHashSet<>();

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

    public Set<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(Set<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    public Set<Groupbuyitem> getGroupbuyitems() {
        return groupbuyitems;
    }

    public void setGroupbuyitems(Set<Groupbuyitem> groupbuyitems) {
        this.groupbuyitems = groupbuyitems;
    }

}