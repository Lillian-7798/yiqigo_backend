package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.OrderDao;
import com.example.yqg_backend.entity.*;
import com.example.yqg_backend.repository.GroupBuyRepository;
import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GroupBuyRepository groupbuyRepository;

    @Override
    public Map<String, Object> getOrderByLeader(Integer groupBuyId) {
        List<Order> lo = orderRepository.findByGroupBuyId(groupBuyId);
        Map<String, Object> rMap = new HashMap<>();

        Groupbuy gb = groupbuyRepository.findByGroupBuyId(groupBuyId);
        String msgType = gb.getTitle() + "--销售订单";
        String MerName = gb.getUser().getName();
        rMap.put("msgType", msgType);
        rMap.put("MerName", MerName);

        List<Map<String,Object>> dataList = new ArrayList<>();
        for(Order o : lo) {
            Map<String ,Object> map = new HashMap<>();
            Integer number = o.getNumber();
            Integer orderId = o.getId();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp payTime = o.getTime();
            String time = formatter.format(payTime);
            Integer TotalPrice = o.getPrice();
            Integer count = o.getCount();
            List<Map<String,Object>> goods = new ArrayList<>();
            List<Orderitem> oiList = o.getOrderitems();
            for(Orderitem oi: oiList) {
                Map<String, Object> m = new HashMap<>();
                Good g = oi.getGoods();
                String name = g.getName();
                String img = g.getImages();
                m.put("name", name);
                m.put("img", img);
                goods.add(m);
            }

            map.put("number",number);
            map.put("orderId",orderId);
            map.put("time",time);
            map.put("TotalPrice",TotalPrice);
            map.put("count",count);
            map.put("goods",goods);

            dataList.add(map);
        }

        rMap.put("dataList", dataList);

        return rMap;
    }

    @Override
    public Map<String, Object> getOrderDetailByLeader(Integer orderID) {
        Order o = orderRepository.getById(orderID);
        Map<String,Object> rMap = new HashMap<>();
        Integer sta = o.getStatus();
        String status = "已支付";
        if(sta == 1) status = "运输中";
        else if(sta == 2) status = "已提货";
        else if(sta == 3) status = "退款";
        Integer total_count = o.getCount();
        Integer total_price = o.getPrice();
        Integer number = o.getNumber();
        String buyer_name = o.getUser().getName();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp payTime = o.getTime();
        String time = formatter.format(payTime);
        String groupBuyer = o.getGroupBuy().getUser().getName();

        Map<String,Object> logistics = new HashMap<>();
        String way = "顾客自提";
        Integer loType = o.getLogisticsType();
        if(loType == 1) way = "国内物流";
        else if(loType == 2) way = "国际物流";
        String buyer_mobile = o.getUser().getMobile();
        String buyer_address = o.getReceiveAddr();
        String note = o.getNote();
        String address = o.getDeliverAddr();
        logistics.put("way", way);
        logistics.put("buyer_mobile", buyer_mobile);
        logistics.put("buyer_address", buyer_address);
        logistics.put("address", address);
        logistics.put("note", note);

        List<Map<String,Object>> goodsList = new ArrayList<>();
        List<Orderitem> oiList = o.getOrderitems();
        for(Orderitem oi: oiList) {
            Map<String,Object> m = new HashMap<>();
            Good g = oi.getGoods();
            String name = g.getName();
            Integer count = oi.getCount();
            Integer price = g.getPrice();
            String image = g.getImages();
            m.put("name",name);
            m.put("count",count);
            m.put("price",price);
            m.put("image",image);
            goodsList.add(m);
        }

        rMap.put("status",status);
        rMap.put("total_count",total_count);
        rMap.put("total_price",total_price);
        rMap.put("number",number);
        rMap.put("buyer_name",buyer_name);
        rMap.put("time",time);
        rMap.put("groupBuyer",groupBuyer);
        rMap.put("logistics",logistics);
        rMap.put("goodsList",goodsList);

        return rMap;
    }
    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Integer getMaxNumber(Integer groupBuyId) {
        return orderRepository.getMaxNumber(groupBuyId);
    }
}
