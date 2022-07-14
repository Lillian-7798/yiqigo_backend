package com.example.yqg_backend.serviceimpl;

import com.example.yqg_backend.dao.UserDao;
import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.entity.Userauth;
import com.example.yqg_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.yqg_backend.entity.User;

import java.util.List;
import java.util.Map;

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

    @Override
    public boolean subscription(Integer lid,Integer mid){return userDao.subscription(lid,mid);}

    @Override
    public boolean cancelsubscription(Integer lid,Integer mid){return userDao.cancelsubscription(lid,mid);}

    @Override
    public boolean updateUser(Integer userID,String name,String mobile,String address) {
        Map<String,Object> m=getUser(userID);
        User u=new User();
        Map<String,Object> m1=getUserByName(name);
        Userauth ua=userDao.getUserauth(userID);
        if (m1!=null && m1.get("id")!=userID) return false;
        u.setId(userID);
        u.setName(name);
        u.setMobile(mobile);
        u.setAddress(address);
        u.setMoney((Integer) m.get("money"));
        ua.setUsername(name);
        userDao.updateUser(u);
        userDao.updateUserauth(ua);
        return true;
    }

}
