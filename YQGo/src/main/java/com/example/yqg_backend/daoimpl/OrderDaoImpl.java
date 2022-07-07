package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.OrderDao;
import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Integer getMaxNumber(Integer groupBuyId) {
        return orderRepository.getMaxNumber(groupBuyId);
    }

    @Override
    public List<Map<String, Object>> getOrderByUser(Integer userID){
        User u = userRepository.getById(userID);
        List<Order> list=orderRepository.getOrderByUser(userID);
        List<Map<String, Object>> rList = new ArrayList<>();
        for (Order o:list) {
            Integer id=o.getId();
            Integer count = o.getCount();
            Integer number = o.getNumber();
            Integer price = o.getPrice();
            Timestamp time = o.getTime();

            Groupbuy gb = o.getGroupBuy();
            User leader = gb.getUser();
            String LeaderName = leader.getName();

            List<Orderitem> listGoods = o.getOrderitems();
            List<Map<String,Object>> url = new ArrayList<>();
            for (Orderitem oi : listGoods) {
                Map<String, Object> map1 = new HashMap<String, Object>();
                Good g = oi.getGoods();
                String image = g.getImages();
                String goodName=g.getName();
                map1.put("image",image);
                map1.put("name",goodName);
                url.add(map1);
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id",id);
            map.put("count",count);
            map.put("number",number);
            map.put("price",price);
            map.put("time",time);
            map.put("LeaderName",LeaderName);
            map.put("urls", url);
            rList.add(map);
        }
        return rList;
    }

    @Override
    public Map<String,Object> getOrderDetail(Integer orderID){
        //return orderRepository.getOrderDetail(orderID);
        Order o=orderRepository.getOrderDetail(orderID);
        Integer id=o.getId();
        Integer logisticsType = o.getLogisticsType();
        String deliverAddr = o.getDeliverAddr();
        String receiveAddr = o.getReceiveAddr();
        String note = o.getNote();
        Integer count = o.getCount();
        Integer number = o.getNumber();
        Integer price = o.getPrice();
        Timestamp time = o.getTime();
        Integer status=o.getStatus();
        User u=o.getUser();
        String userName = u.getName();
        String userMobile = u.getMobile();

        Groupbuy gb = o.getGroupBuy();
        User leader = gb.getUser();
        String LeaderName = leader.getName();
        String title = gb.getTitle();

        List<Orderitem> listGoods = o.getOrderitems();
        List<Map<String,Object>> url = new ArrayList<>();
        for (Orderitem oi : listGoods) {
            Map<String, Object> map1 = new HashMap<String, Object>();
            Good g = oi.getGoods();
            String image = g.getImages();
            String goodName=g.getName();
            Integer theprice=g.getPrice();
            Integer thecount=oi.getCount();
            map1.put("image",image);
            map1.put("name",goodName);
            map1.put("price",theprice);
            map1.put("count",thecount);
            url.add(map1);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",id);
        map.put("logisticsType", logisticsType);
        map.put("deliverAddr", deliverAddr);
        map.put("receiveAddr", receiveAddr);
        map.put("note", note);
        map.put("count",count);
        map.put("number",number);
        map.put("price",price);
        map.put("time",time);
        map.put("userName",userName);
        map.put("userMobile",userMobile);
        map.put("LeaderName",LeaderName);
        map.put("status",status);
        map.put("urls", url);
        return map;
    }

}
