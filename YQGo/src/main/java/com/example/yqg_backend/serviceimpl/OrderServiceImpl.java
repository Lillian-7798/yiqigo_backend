package com.example.yqg_backend.serviceimpl;

import com.example.yqg_backend.dao.OrderDao;
import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public List<Map<String, Object>> getOrderByUser(Integer userID){
      return orderDao.getOrderByUser(userID);
    }

    @Override
    public Map<String,Object> getOrderDetail(Integer orderID){
      return orderDao.getOrderDetail(orderID);
    }
}
