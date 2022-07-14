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

    @Override
    public int lockOrder(RequestOrder requestOrder) {
        for (RequestGoods reqGood : requestOrder.getGoods()) {
            Groupbuyitem gbItem = groupBuyItemDao.getGroupBuyItem(requestOrder.getGroupBuyId(), reqGood.getGoodsId());
            int cur_count = reqGood.getCount();
            if (gbItem.getInventory() < cur_count) {
                return -1;
            }
        }

        int total_count = 0;
        int total_price = 0;
        List<Orderitem> orderItems = new ArrayList<>();
        List<Groupbuyitem> groupBuyItems = new ArrayList<>();
        User u = userDao.getUser(requestOrder.getUserId());
        Groupbuy gb = groupBuyDao.getGroupBuy(requestOrder.getGroupBuyId());

        Order order = new Order(requestOrder.getLogisticsType(),
                requestOrder.getNote());
        order.setUser(u);
        order.setGroupBuy(gb);
        order.setDeliverAddr(gb.getUser().getAddress());
        order.setReceiveAddr(u.getAddress());
        order.setTime(new Timestamp(System.currentTimeMillis()));
        // 初始状态为4，表示待支付
        order.setStatus(4);
        //跟团号
        Integer maxNumber = orderDao.getMaxNumber(requestOrder.getGroupBuyId());
        if (maxNumber == null) {
            order.setNumber(1);
        }
        else {
            order.setNumber(maxNumber + 1);
        }

        //需要购买的商品列表
        for (RequestGoods reqGood : requestOrder.getGoods()) {
            Groupbuyitem gbItem = groupBuyItemDao.getGroupBuyItem(requestOrder.getGroupBuyId(), reqGood.getGoodsId());
            int cur_count = reqGood.getCount();

            //已售数量
            Integer soldNum = gbItem.getSoldNum();
            gbItem.setInventory(gbItem.getInventory() - cur_count);
            gbItem.setSoldNum(soldNum+cur_count);
            total_count += cur_count;
            Good good = goodDao.getGood(reqGood.getGoodsId());

            //如果不是秒杀商品
            if(!gbItem.getIsSecKill()) {
                groupBuyItems.add(gbItem);
                total_price += good.getPrice() * cur_count;
                orderItems.add(new Orderitem(good, cur_count));
                order.setDiscount(0);
            }
            //如果是秒杀商品
            else {
                Integer killNum = gbItem.getKillNum();
                Integer killPrice = gbItem.getKillPrice();

                //如果不符合秒杀标准: 下单前的已售数量已经超过秒杀数量（且购买量不会超过库存）
                if(soldNum > killNum) {
                    groupBuyItems.add(gbItem);
                    total_price += good.getPrice() * cur_count;
                    orderItems.add(new Orderitem(good, cur_count));
                    order.setDiscount(0);
                }
                //如果完全符合秒杀标准：下单后的数量仍不超过秒杀数量
                else if(soldNum+cur_count <= killNum) {
                    groupBuyItems.add(gbItem);
                    total_price += killPrice * cur_count;
                    orderItems.add(new Orderitem(good, cur_count));
                    order.setDiscount((good.getPrice() - killPrice) * cur_count);
                }
                //如果部分符合秒杀标准：少于killNum的部分享受秒杀价，超过的部分原价
                else {
                    groupBuyItems.add(gbItem);
                    total_price += good.getPrice() * (cur_count-(killNum-soldNum)) + killPrice * (killNum-soldNum);
                    orderItems.add(new Orderitem(good, cur_count));
                    order.setDiscount((good.getPrice() - killPrice) * (killNum-soldNum));
                }
            }
        }
        order.setCount(total_count);
        order.setPrice(total_price);
        orderDao.addOrder(order);
        groupBuyItemDao.updateGroupBuyItems(groupBuyItems);
        userDao.updateUser(u);

        for (Orderitem item : orderItems) {
            item.setId(new OrderitemId(order.getId(), item.getGoods().getId()));
            item.setOrder(order);
        }
        orderItemDao.addOrderItems(orderItems);
        return order.getId();
    }

    @Override
    public boolean pay(Integer orderID) {
        return orderDao.pay(orderID);
    }

    @Override
    public boolean cancelByUser(Integer orderID) {
        return orderDao.cancelByUser(orderID);
    }
}
