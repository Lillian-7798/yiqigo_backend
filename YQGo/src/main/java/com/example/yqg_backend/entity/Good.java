package com.example.yqg_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    public Good(String name,String description,Integer price,String images){
        this.name=name;
        this.description=description;
        this.price=price;
        this.images=images;
    }

    public Good() {

    }

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

}