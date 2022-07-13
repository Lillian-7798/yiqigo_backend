package com.example.yqg_backend.dao;

import com.example.yqg_backend.entity.Orderitem;

import java.util.List;

public interface OrderItemDao {
    void addOrderItems(List<Orderitem> orderitems);
}
