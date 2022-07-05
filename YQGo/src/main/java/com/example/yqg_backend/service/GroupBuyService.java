package com.example.yqg_backend.service;

import com.example.yqg_backend.entity.RequestGoods2;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface GroupBuyService {

    void addGroupBuy(Integer userID, String title, String description, Integer logisticsType, Timestamp startTime,
                     Timestamp endTime, List<RequestGoods2> goodslist);
}
