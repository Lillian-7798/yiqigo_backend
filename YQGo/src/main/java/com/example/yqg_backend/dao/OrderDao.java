package com.example.yqg_backend.dao;

import com.example.yqg_backend.entity.Order;

import java.util.Map;

public interface OrderDao {
    Map<String, Object> getOrderByLeader(Integer groupBuyId);
    Map<String, Object> getOrderDetailByLeader(Integer orderID);
    void addOrder(Order order);
    Integer getMaxNumber(Integer groupBuyId);
}
