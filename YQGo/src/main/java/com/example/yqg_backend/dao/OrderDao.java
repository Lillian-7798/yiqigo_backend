package com.example.yqg_backend.dao;

import com.example.yqg_backend.entity.Order;

public interface OrderDao {
    void addOrder(Order order);
    Integer getMaxNumber(Integer groupBuyId);
}
