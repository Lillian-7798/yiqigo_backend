package com.example.yqg_backend.serviceimpl;

import com.example.yqg_backend.dao.GroupBuyDao;
import com.example.yqg_backend.service.GroupBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
