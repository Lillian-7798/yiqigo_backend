package com.example.yqg_backend.dao;

import com.example.yqg_backend.entity.Groupbuyitem;

import java.util.List;

public interface GroupBuyItemDao {

    void addGroupBuyItems(List<Groupbuyitem> groupbuyitems);
    void updateGroupBuyItems(List<Groupbuyitem> groupbuyitems);
    Groupbuyitem getGroupBuyItem(Integer groupbuyId, Integer goodsId);
}
