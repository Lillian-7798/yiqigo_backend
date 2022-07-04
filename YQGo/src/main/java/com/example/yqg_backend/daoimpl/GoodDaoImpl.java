package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.GoodDao;
import com.example.yqg_backend.entity.Good;
import com.example.yqg_backend.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoodDaoImpl implements GoodDao {
    @Autowired
    private GoodRepository goodRepository;

    @Override
    public Good getGood(Integer goodsId) {
        return goodRepository.getById(goodsId);
    }
}
