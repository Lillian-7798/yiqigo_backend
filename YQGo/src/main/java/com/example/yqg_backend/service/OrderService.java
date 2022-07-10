package com.example.yqg_backend.service;

import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.entity.RequestOrder;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Map<String, Object>> getOrderByUser(Integer userID);

    Map<String,Object> getOrderDetail(Integer orderID);
    Map<String, Object> getOrderByLeader(Integer groupBuyId);
    Map<String, Object> getOrderDetailByLeader(Integer orderID);

    // return > 0 --- 正常，返回orderId
    // return = -1 --- 库存不足
    // return = -2 --- 用户余额不足
    int addOrder(RequestOrder requestOrder);

    boolean cancelOrder(Integer orderId);
}
