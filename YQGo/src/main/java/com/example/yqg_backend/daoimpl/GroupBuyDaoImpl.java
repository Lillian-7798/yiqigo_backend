package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.GroupBuyDao;
import com.example.yqg_backend.entity.*;
import com.example.yqg_backend.repository.GroupbuyRepository;
import com.example.yqg_backend.repository.OrderRepository;
import com.example.yqg_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class GroupBuyDaoImpl implements GroupBuyDao {
    @Autowired
    private GroupbuyRepository groupbuyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Map<String, Object>> getUserGB(Integer uid) {
        User u = userRepository.getById(uid);
        List<Groupbuy> list = groupbuyRepository.findByUserId(u);

        List<Map<String, Object>> rList = new ArrayList<>();

        for (Groupbuy gb: list) {
            String title = gb.getTitle();
            Integer GroupBuyId = gb.getId();
            Integer sta = gb.getStatus();
            Timestamp startTime = gb.getStartTime();
            Timestamp endTime = gb.getEndTime();
            Timestamp current = new Timestamp(System.currentTimeMillis());
            String status = "已结束";
            if(sta == 0)
                status = "提前结束";
            else if(endTime.getTime() >= current.getTime() && sta==1)
                status = "正在抢购中";
            else if(startTime.getTime() > current.getTime() && sta==1)
                status = "未开始";
            else if(sta==2)
                status = "已删除";

            List<Groupbuyitem> listGoods = gb.getGroupbuyitems();
            List<String> url = new ArrayList<>();
            int minPrice = 10000;
            for(Groupbuyitem gbi : listGoods) {
                Good g = gbi.getGoods();
                int price = g.getPrice();
                String image = g.getImages();
                if(price <= minPrice)
                    minPrice = price;
                url.add(image);
            }

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("GroupBuyId", GroupBuyId);
            map.put("userName", title);
            map.put("price", minPrice);
            map.put("status", status);
            map.put("urls", url);
            rList.add(map);
        }
        return rList;
    }

    @Override
    public Map<String, Object> getGroupBuyDetail(Integer groupBuyId) {
        Map<String, Object> map = new HashMap<String, Object>();

        Groupbuy gb = groupbuyRepository.findByGroupBuyId(groupBuyId);
        map.put("storeName",gb.getUser().getName());
        map.put("groupName", gb.getTitle());

        Integer loType = gb.getLogisticsType();
        String mode = "用户自提";   //loType == 0
        if(loType == 1)
            mode = "国内物流";
        else if(loType == 2)
            mode = "国际物流";
        map.put("mode", mode);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp startTime = gb.getStartTime();
        String fStartTime = formatter.format(startTime);
        String st = "开始时间: "+fStartTime;
        Timestamp endTime = gb.getEndTime();
        String fEndTime = formatter.format(endTime);
        String et = "结束时间: "+fEndTime;
        map.put("start_time", st);
        map.put("end_time", et);

        map.put("description", gb.getDescription());

        List<Groupbuyitem> gbiList = gb.getGroupbuyitems();
        List<Map<String, Object>> goods_list = new ArrayList<>();
        for(Groupbuyitem gbi : gbiList) {
            Map<String, Object> m = new HashMap<String, Object>();
            Good g = gbi.getGoods();
            m.put("name", g.getName());
            m.put("image", g.getImages());
            m.put("price", g.getPrice());
            Integer number = 0;
            m.put("number", number);
            goods_list.add(m);
        }
        map.put("goods_list", goods_list);
        return map;
    }

    @Override
    public Groupbuy getGroupBuy(Integer groupBuyId) {
        return groupbuyRepository.getById(groupBuyId);
    }

    @Override
    public boolean deleteGroupBuy(Integer groupBuyId) {
        Groupbuy gb = groupbuyRepository.findByGroupBuyId(groupBuyId);
        if(gb.getStatus() != 2) {
            gb.setStatus(2);
            List<Order> lo = gb.getOrders();
            for(Order o : lo) {
                if(o.getStatus()!= 3) {
                    o.setStatus(3);
                    User u = o.getUser();
                    u.setMoney(u.getMoney()+o.getPrice());
                    userRepository.save(u);
                    orderRepository.save(o);
                }
            }
            groupbuyRepository.save(gb);
            return true;
        }
        return false;
    }

    @Override
    public void addGroupbuy(Groupbuy groupbuy){groupbuyRepository.save(groupbuy);}
}
