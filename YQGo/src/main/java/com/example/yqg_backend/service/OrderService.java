package com.example.yqg_backend.service;

import com.example.yqg_backend.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Map<String, Object>> getOrderByUser(Integer userID);

    Map<String,Object> getOrderDetail(Integer orderID);
}
