package com.example.yqg_backend.dao;

import com.example.yqg_backend.entity.Groupbuy;

import java.util.List;
import java.util.Map;

public interface GroupBuyDao {
    List<Map<String, Object>> getUserGB(Integer uid);
    Map<String, Object> getGroupBuyDetail(Integer groupBuyId,Integer userId);
    Groupbuy getGroupBuy(Integer groupBuyId);
    void addGroupbuy(Groupbuy groupbuy);
    List<Map> searchGB(String keyword,String searchBy);

    List<Map> getIndexGB(Integer userId);
}
