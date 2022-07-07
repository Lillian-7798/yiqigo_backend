package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.GroupBuyItemDao;
import com.example.yqg_backend.entity.Groupbuyitem;
import com.example.yqg_backend.repository.GroupbuyitemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupBuyItemDaoImpl implements GroupBuyItemDao {

    @Autowired
    GroupbuyitemRepository groupbuyitemRepository;

    @Override
    public void addGroupBuyItems(List<Groupbuyitem> groupbuyitems){ groupbuyitemRepository.saveAll(groupbuyitems);}
}
