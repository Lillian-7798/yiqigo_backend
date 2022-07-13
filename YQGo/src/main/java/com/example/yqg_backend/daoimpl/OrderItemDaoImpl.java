package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.OrderItemDao;
import com.example.yqg_backend.entity.Orderitem;
import com.example.yqg_backend.repository.OrderitemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {
    @Autowired
    OrderitemRepository orderitemRepository;

    @Override
    public void addOrderItems(List<Orderitem> orderitems) {
        orderitemRepository.saveAll(orderitems);
    }
}
