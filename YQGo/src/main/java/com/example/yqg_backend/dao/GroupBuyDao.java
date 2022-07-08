package com.example.yqg_backend.dao;

import com.example.yqg_backend.entity.Groupbuy;
import com.example.yqg_backend.entity.ModifiedGroupBuy;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface GroupBuyDao {
    List<Map<String, Object>> getUserGB(Integer uid);
    Map<String, Object> getGroupBuyDetail(Integer groupBuyId);
    Groupbuy getGroupBuy(Integer groupBuyId);
    boolean deleteGroupBuy(Integer groupBuyId);
    boolean earlyEnd(Integer groupBuyId);
    Map<String, Object> getGroupBuyInfo(Integer groupBuyId);
    boolean ModifyGroupBuy(ModifiedGroupBuy modifiedGroupBuy);
    void addGroupbuy(Groupbuy groupbuy);

    List<Map> searchGB(String keyword,String searchBy);
}
