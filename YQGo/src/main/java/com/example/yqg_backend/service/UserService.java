package com.example.yqg_backend.service;

import com.example.yqg_backend.entity.User;

import java.util.Map;

public interface UserService {
    Map<String,Object> getUser(Integer userID);

    Map<String,Object> getUserByName(String name);

    Boolean checkUser(String userName,String password);

    Boolean addUser(String userName,String password);
}
