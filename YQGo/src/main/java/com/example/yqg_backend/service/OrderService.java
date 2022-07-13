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
    // return > 0 --- 正常，返回orderId.
    //                 这种情况下，后端分配跟团号，对于秒杀商品确定其是否符合秒杀要求
    // return = -1 --- 库存不足
    int lockOrder(RequestOrder requestOrder);

    //return true: 支付成功
    //return false: 支付失败（用户余额不足）
    boolean pay(Integer orderID);
    boolean cancelByUser(Integer orderID);
}
