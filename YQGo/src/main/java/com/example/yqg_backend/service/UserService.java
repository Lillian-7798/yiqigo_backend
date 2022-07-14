package com.example.yqg_backend.service;

import com.example.yqg_backend.entity.User;

import java.util.Map;

import java.util.Map;

public interface UserService {
    Map<String,Object> getUser(Integer userID);

    Map<String,Object> getUserByName(String name);

    Boolean checkUser(String userName,String password);

    Boolean addUser(String userName,String password);
    
    boolean subscription(Integer lid,Integer mid);

    boolean cancelsubscription(Integer lid,Integer mid);

    boolean updateUser(Integer userID,String name,String mobile,String address);

}
