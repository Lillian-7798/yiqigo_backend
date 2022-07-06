package com.example.yqg_backend.service;

<<<<<<< HEAD
import com.example.yqg_backend.entity.RequestGoods2;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface GroupBuyService {

    void addGroupBuy(Integer userID, String title, String description, Integer logisticsType, Timestamp startTime,
                     Timestamp endTime, List<RequestGoods2> goodslist);
=======
import java.util.List;
import java.util.Map;

public interface GroupBuyService {
    List<Map<String, Object>> getUserGB(Integer uid);
    Map<String, Object> getGroupBuyDetail(Integer groupBuyId);
>>>>>>> d4f1cdb6e7680c71f6205382fbec84376c4bc86e
}
