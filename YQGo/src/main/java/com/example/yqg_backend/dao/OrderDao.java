package com.example.yqg_backend.dao;

import com.example.yqg_backend.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {
    Map<String, Object> getOrderByLeader(Integer groupBuyId);
    Map<String, Object> getOrderDetailByLeader(Integer orderID);
    void addOrder(Order order);
    Integer getMaxNumber(Integer groupBuyId);
    
    List<Map<String, Object>> getOrderByUser(Integer userID);

    Map<String,Object> getOrderDetail(Integer orderID);
    boolean cancelOrder(Integer orderId);
    boolean pay(Integer orderID);
    boolean cancelByUser(Integer orderID);
}
