package com.example.yqg_backend.service;

import com.example.yqg_backend.entity.RequestOrder;

import java.util.Map;

public interface OrderService {
    Map<String, Object> getOrderByLeader(Integer groupBuyId);
    Map<String, Object> getOrderDetailByLeader(Integer orderID);
    void addOrder(RequestOrder requestOrder);
}
