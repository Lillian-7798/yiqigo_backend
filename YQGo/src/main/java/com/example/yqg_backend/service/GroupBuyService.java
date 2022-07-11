package com.example.yqg_backend.service;

import com.example.yqg_backend.entity.ModifiedGroupBuy;
import com.example.yqg_backend.entity.RequestGoods2;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface GroupBuyService {

    void addGroupBuy(Integer userID, String title, String description, Integer logisticsType, Timestamp startTime,
                     Timestamp endTime, List<RequestGoods2> goodslist);
    List<Map<String, Object>> getUserGB(Integer uid);
    Map<String, Object> getGroupBuyDetail(Integer groupBuyId,Integer userId);

    List<Map> searchGB(String keyword,String searchBy);

    List<Map> getIndexGB(Integer userId);
    boolean deleteGroupBuy(Integer groupBuyId);
    boolean earlyEnd(Integer groupBuyId);
    Map<String, Object> getGroupBuyInfo(Integer groupBuyId);
    boolean ModifyGroupBuy(ModifiedGroupBuy modifiedGroupBuy);
}
