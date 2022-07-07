package com.example.yqg_backend.serviceimpl;

import com.example.yqg_backend.dao.GoodDao;
import com.example.yqg_backend.dao.GroupBuyDao;
import com.example.yqg_backend.dao.GroupBuyItemDao;
import com.example.yqg_backend.dao.UserDao;
import com.example.yqg_backend.entity.*;

import com.example.yqg_backend.dao.GroupBuyDao;
import com.example.yqg_backend.service.GroupBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GroupBuyServiceImpl implements GroupBuyService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GoodDao goodDao;

    @Autowired
    private GroupBuyDao groupBuyDao;

    @Autowired
    private GroupBuyItemDao groupBuyItemDao;
    @Override
    public void addGroupBuy(Integer userID, String title, String description, Integer logisticsType, Timestamp startTime,
                            Timestamp endTime, List<RequestGoods2> goodslist){
        Groupbuy groupbuy = new Groupbuy(title,description,logisticsType,startTime,endTime);
        groupbuy.setUser(userDao.getUser(userID));
        groupBuyDao.addGroupbuy(groupbuy);

        List<Groupbuyitem> groupbuyitems = new ArrayList<>();
        for(RequestGoods2 item:goodslist){
            Good good = new Good(item.getName(),item.getGoods_des(),item.getSelling_price(),item.getImage().get(0));
            goodDao.addGood(good);
            groupbuyitems.add(new Groupbuyitem(good,item.getInventory(),item.getCost_price(),item.isIskill()));
        }
        for(Groupbuyitem Gitem:groupbuyitems){
            Gitem.setId(new GroupbuyitemId(groupbuy.getId(),Gitem.getGoods().getId()));
            Gitem.setGroupBuy(groupbuy);
        }
        groupBuyItemDao.addGroupBuyItems(groupbuyitems);
    }
    @Override
    public List<Map<String, Object>> getUserGB(Integer uid) {
        return groupBuyDao.getUserGB(uid);
    }

    @Override
    public Map<String, Object> getGroupBuyDetail(Integer groupBuyId) {
        return groupBuyDao.getGroupBuyDetail(groupBuyId);}
}
