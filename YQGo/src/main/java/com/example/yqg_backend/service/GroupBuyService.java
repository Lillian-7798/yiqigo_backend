package com.example.yqg_backend.service;

import java.util.List;
import java.util.Map;

public interface GroupBuyService {
    List<Map<String, Object>> getUserGB(Integer uid);
    Map<String, Object> getGroupBuyDetail(Integer groupBuyId);
    boolean deleteGroupBuy(Integer groupBuyId);
}
