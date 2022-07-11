package com.example.yqg_backend.entity;

import java.util.List;

public class ModifiedGoods {
    private String name;
    private String goods_des;
    private List<String> image;
    private Integer selling_price;
    private Integer inventory;
    private Integer cost_price;
    private boolean iskill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoods_des() {
        return goods_des;
    }

    public void setGoods_des(String goods_des) {
        this.goods_des = goods_des;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public Integer getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(Integer selling_price) {
        this.selling_price = selling_price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getCost_price() {
        return cost_price;
    }

    public void setCost_price(Integer cost_price) {
        this.cost_price = cost_price;
    }

    public boolean isIskill() {
        return iskill;
    }

    public void setIskill(boolean iskill) {
        this.iskill = iskill;
    }
}
