package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.OrderDao;
import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Integer getMaxNumber(Integer groupBuyId) {
        return orderRepository.getMaxNumber(groupBuyId);
    }

    @Override
    public List<Order> getOrderByUser(Integer userID){
        List<Order> l=orderRepository.getOrderByUser(userID);
        System.out.println(l);
        return l;
    }

    @Override
    public Order getOrderDetail(Integer orderID){
        return orderRepository.getOrderDetail(orderID);
    }

}
