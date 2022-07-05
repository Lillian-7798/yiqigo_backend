package com.example.yqg_backend.serviceimpl;

import com.example.yqg_backend.dao.*;
import com.example.yqg_backend.entity.*;
import com.example.yqg_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderItemDao orderItemDao;
    @Autowired
    UserDao userDao;
    @Autowired
    GroupBuyDao groupBuyDao;
    @Autowired
    GoodDao goodDao;

    @Override
    public void addOrder(RequestOrder requestOrder) {        // 缺乏库存检查
        Order order = new Order(requestOrder.getLogisticsType(),
                requestOrder.getDeliverAddr(),
                requestOrder.getReceiveAddr(),
                requestOrder.getNote());
        order.setUser(userDao.getUser(requestOrder.getUserId()));
        order.setGroupBuy(groupBuyDao.getGroupBuy(requestOrder.getGroupBuyId()));
        order.setTime(new Timestamp(System.currentTimeMillis()));
        order.setStatus(1);         // 暂时设状态为1
        Integer maxNumber = orderDao.getMaxNumber(requestOrder.getGroupBuyId());
        if (maxNumber == null) {
            order.setNumber(1);
        }
        else {
            order.setNumber(maxNumber + 1);
        }

        int total_count = 0;
        int total_price = 0;
        List<Orderitem> orderitems = new ArrayList<>();
        for (RequestGoods reqGood : requestOrder.getGoods()) {
            total_count += reqGood.getCount();
            Good good = goodDao.getGood(reqGood.getGoodsId());
            total_price += good.getPrice() * reqGood.getCount();
            orderitems.add(new Orderitem(good, reqGood.getCount()));
        }
        order.setCount(total_count);
        order.setPrice(total_price);
        orderDao.addOrder(order);

        for (Orderitem item : orderitems) {
            item.setId(new OrderitemId(order.getId(), item.getGoods().getId()));
            item.setOrder(order);
        }
        orderItemDao.addOrderItems(orderitems);
    }

    @Override
    public List<Order> getOrderByUser(Integer userID){
      return orderDao.getOrderByUser(userID);
    }

    @Override
    public Order getOrderDetail(Integer orderID){
      return orderDao.getOrderDetail(orderID);
    }
}
