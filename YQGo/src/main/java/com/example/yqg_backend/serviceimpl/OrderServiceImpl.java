package com.example.yqg_backend.serviceimpl;

import com.example.yqg_backend.dao.OrderDao;
import com.example.yqg_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;


    @Override
    public Map<String, Object> getOrderByLeader(Integer groupBuyId) {
        return orderDao.getOrderByLeader(groupBuyId);
    }

    @Override
    public Map<String, Object> getOrderDetailByLeader(Integer orderID) {
        return orderDao.getOrderDetailByLeader(orderID);
    }
}
