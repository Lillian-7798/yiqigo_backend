package com.example.yqg_backend.dao;

import com.example.yqg_backend.entity.User;

import java.util.Map;

public interface UserDao {
    User getUser(Integer userId);
    void updateUser(User user);
    Map<String,Object> getUser2(Integer userId);

    Map<String,Object> getUserByName(String name);

    Boolean checkUser(String userName,String password);

    Boolean addUser(String userName,String password);
    boolean subscription(Integer lid,Integer mid);

    boolean cancelsubscription(Integer lid,Integer mid);
}

