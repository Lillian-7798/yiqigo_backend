package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.GroupBuyDao;
import com.example.yqg_backend.entity.Groupbuy;
import com.example.yqg_backend.repository.GroupbuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupBuyDaoImpl implements GroupBuyDao {
    @Autowired
    GroupbuyRepository groupbuyRepository;

    @Override
    public Groupbuy getGroupBuy(Integer groupBuyId) {
        return groupbuyRepository.getById(groupBuyId);
    }
}
