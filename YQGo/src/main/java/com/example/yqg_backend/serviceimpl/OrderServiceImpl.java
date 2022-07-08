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
    @Autowired
    private GroupBuyItemDao groupBuyItemDao;

    @Override
    public Map<String, Object> getOrderByLeader(Integer groupBuyId) {
        return orderDao.getOrderByLeader(groupBuyId);
    }

    @Override
    public Map<String, Object> getOrderDetailByLeader(Integer orderID) {
        return orderDao.getOrderDetailByLeader(orderID);
    }

    @Override
    public int addOrder(RequestOrder requestOrder) {
        User user = userDao.getUser(requestOrder.getUserId());
        Groupbuy groupbuy = groupBuyDao.getGroupBuy(requestOrder.getGroupBuyId());
        Order order = new Order(requestOrder.getLogisticsType(),
                requestOrder.getNote());
        order.setUser(user);
        order.setGroupBuy(groupbuy);
        order.setDeliverAddr(groupbuy.getUser().getAddress());
        order.setReceiveAddr(user.getAddress());
        order.setTime(new Timestamp(System.currentTimeMillis()));
        order.setStatus(0);         // 初始状态为0
        Integer maxNumber = orderDao.getMaxNumber(requestOrder.getGroupBuyId());
        if (maxNumber == null) {
            order.setNumber(1);
        }
        else {
            order.setNumber(maxNumber + 1);
        }

        int cur_count;
        int total_count = 0;
        int total_price = 0;
        List<Orderitem> orderitems = new ArrayList<>();
        List<Groupbuyitem> groupbuyitems = new ArrayList<>();
        for (RequestGoods reqGood : requestOrder.getGoods()) {
            Groupbuyitem gbitem = groupBuyItemDao.getGroupBuyItem(requestOrder.getGroupBuyId(), reqGood.getGoodsId());
            cur_count = reqGood.getCount();
            if (gbitem.getInventory() < cur_count) {
                return -1;
            }
            else {
                gbitem.setInventory(gbitem.getInventory() - cur_count);
            }
            groupbuyitems.add(gbitem);
            total_count += cur_count;
            Good good = goodDao.getGood(reqGood.getGoodsId());
            total_price += good.getPrice() * reqGood.getCount();
            orderitems.add(new Orderitem(good, reqGood.getCount()));
        }
        order.setCount(total_count);
        order.setPrice(total_price);

        if (user.getMoney() < total_price) {
            return -2;
        }
        else {
            user.setMoney(user.getMoney() - total_price);
        }
        orderDao.addOrder(order);
        groupBuyItemDao.updateGroupBuyItems(groupbuyitems);
        userDao.updateUser(user);

        for (Orderitem item : orderitems) {
            item.setId(new OrderitemId(order.getId(), item.getGoods().getId()));
            item.setOrder(order);
        }
        orderItemDao.addOrderItems(orderitems);
        return order.getId();
    }

    @Override
    public List<Map<String, Object>> getOrderByUser(Integer userID){
      return orderDao.getOrderByUser(userID);
    }

    @Override
    public Map<String,Object> getOrderDetail(Integer orderID){
      return orderDao.getOrderDetail(orderID);
    }

    @Override
    public boolean cancelOrder(Integer orderId) {
        if(orderDao.cancelOrder(orderId))
            return true;
        else return false;
    }
}
