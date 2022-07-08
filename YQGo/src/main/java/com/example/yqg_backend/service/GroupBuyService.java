package com.example.yqg_backend.service;

import com.example.yqg_backend.entity.ModifiedGroupBuy;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface GroupBuyService {
    List<Map<String, Object>> getUserGB(Integer uid);
    Map<String, Object> getGroupBuyDetail(Integer groupBuyId);
    boolean deleteGroupBuy(Integer groupBuyId);
    boolean earlyEnd(Integer groupBuyId);
    Map<String, Object> getGroupBuyInfo(Integer groupBuyId);
    boolean ModifyGroupBuy(ModifiedGroupBuy modifiedGroupBuy);
}
