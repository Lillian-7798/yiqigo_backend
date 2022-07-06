package com.example.yqg_backend.dao;

import com.example.yqg_backend.entity.User;

public interface UserDao {
    User getUser(Integer userId);
}
