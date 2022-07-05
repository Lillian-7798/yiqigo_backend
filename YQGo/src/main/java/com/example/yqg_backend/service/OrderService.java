package com.example.yqg_backend.service;

import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.entity.RequestOrder;

public interface OrderService {
    Order addOrder(RequestOrder requestOrder);
}
