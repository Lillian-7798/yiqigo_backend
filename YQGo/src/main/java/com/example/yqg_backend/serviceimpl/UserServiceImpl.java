package com.example.yqg_backend.serviceimpl;

import com.example.yqg_backend.dao.UserDao;
import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.yqg_backend.entity.User;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Map<String,Object> getUser(Integer userID){
        return userDao.getUser2(userID);
    }

    @Override
    public Map<String,Object> getUserByName(String name){
        return userDao.getUserByName(name);
    }

    @Override
    public Boolean checkUser(String userName,String password){
        return userDao.checkUser(userName,password);
    }

    @Override
    public Boolean addUser(String userName,String password){
        return userDao.addUser(userName,password);
    }

}
