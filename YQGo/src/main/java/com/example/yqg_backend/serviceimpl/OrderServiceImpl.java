package com.example.yqg_backend.serviceimpl;

import com.example.yqg_backend.dao.OrderDao;
import com.example.yqg_backend.dao.*;
import com.example.yqg_backend.entity.*;
import com.example.yqg_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private GroupBuyDao groupBuyDao;
    @Autowired
    private GoodDao goodDao;

    @Override
    public Map<String, Object> getOrderByLeader(Integer groupBuyId) {
        return orderDao.getOrderByLeader(groupBuyId);
    }

    @Override
    public Map<String, Object> getOrderDetailByLeader(Integer orderID) {
        return orderDao.getOrderDetailByLeader(orderID);
    }

    @Override
    public void addOrder(RequestOrder requestOrder) {        // 缺乏库存检查
        Order order = new Order(requestOrder.getLogisticsType(),
                requestOrder.getDeliverAddr(),
                requestOrder.getReceiveAddr(),
                requestOrder.getNote());
        order.setUser(userDao.getUserById(requestOrder.getUserId()));
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
}
