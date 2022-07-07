package com.example.yqg_backend.dao;

import com.example.yqg_backend.entity.Good;

public interface GoodDao {
    Good getGood(Integer goodsId);

    void addGood(Good good);
}
