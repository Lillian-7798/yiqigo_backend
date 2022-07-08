package com.example.yqg_backend.serviceimpl;

import com.example.yqg_backend.dao.GroupBuyDao;
import com.example.yqg_backend.entity.ModifiedGroupBuy;
import com.example.yqg_backend.service.GroupBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service

public class GroupBuyServiceImpl implements GroupBuyService {
    @Autowired
    private GroupBuyDao groupBuyDao;

    @Override
    public List<Map<String, Object>> getUserGB(Integer uid) {
        return groupBuyDao.getUserGB(uid);
    }

    @Override
    public Map<String, Object> getGroupBuyDetail(Integer groupBuyId) {
        return groupBuyDao.getGroupBuyDetail(groupBuyId);
    }

    @Override
    public boolean deleteGroupBuy(Integer groupBuyId) {
        if(groupBuyDao.deleteGroupBuy(groupBuyId))
            return true;
        return false;
    }

    @Override
    public boolean earlyEnd(Integer groupBuyId) {
        if(groupBuyDao.earlyEnd(groupBuyId))
            return true;
        else return false;
    }

    @Override
    public Map<String, Object> getGroupBuyInfo(Integer groupBuyId) {
        return groupBuyDao.getGroupBuyInfo(groupBuyId);
    }

    @Override
    public boolean ModifyGroupBuy(ModifiedGroupBuy modifiedGroupBuy) {
        if(groupBuyDao.ModifyGroupBuy(modifiedGroupBuy))
            return true;
        return false;
    }


}
