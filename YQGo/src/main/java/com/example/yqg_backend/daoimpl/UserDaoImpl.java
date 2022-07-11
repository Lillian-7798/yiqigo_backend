package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.UserDao;
import com.example.yqg_backend.entity.User;
import com.example.yqg_backend.entity.Userauth;
import com.example.yqg_backend.repository.UserRepository;
import com.example.yqg_backend.repository.UserauthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserauthRepository userauthRepository;

    @Override
    public User getUser(Integer userId) {
        return userRepository.getById(userId);
    }

    @Override
    public Map<String,Object> getUser2(Integer userId) {
        User u=userRepository.getUserById(userId);
        Integer id=u.getId();
        String name=u.getName();
        String mobile=u.getMobile();
        String address=u.getAddress();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",id);
        map.put("name",name);
        map.put("mobile",mobile);
        map.put("address",address);
        return map;
    }

    @Override
    public Map<String,Object> getUserByName(String name) {
        User u=userRepository.getUserByName(name);
        Integer id=u.getId();
        String username=u.getName();
        String mobile=u.getMobile();
        String address=u.getAddress();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",id);
        map.put("name",username);
        map.put("mobile",mobile);
        map.put("address",address);
        return map;
    }

    @Override
    public Boolean checkUser(String userName,String password) {
        Userauth ua = userauthRepository.getUserauthByName(userName);
        if (ua==null) return false;
        if (password.equals(ua.getPassword())) return true;
        return false;
    }

    @Override
    public Boolean addUser(String userName,String password){
        Userauth ua = userauthRepository.getUserauthByName(userName);
        if (ua!=null) return false;
        User u=new User();
        u.setName(userName);
        userRepository.save(u);
        Userauth userauth=new Userauth();
        userauth.setUsername(userName);
        userauth.setPassword(password);
        userauth.setId(u.getId());
        userauthRepository.save(userauth);
        return true;
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean subscription(Integer lid,Integer mid){
        if(lid==mid) return false;
        else {
            User leader = userRepository.getUserById(lid);
            User member = userRepository.getUserById(mid);
            member.getLeaders().add(leader);
            userRepository.save(member);
            leader.getMembers().add(member);
            userRepository.save(leader);
            return true;
        }
    }

    @Override
    public boolean cancelsubscription(Integer lid,Integer mid){
        if(lid==mid) return false;
        else{
            User leader = userRepository.getUserById(lid);
            User member = userRepository.getUserById(mid);
            member.getLeaders().remove(leader);
            userRepository.save(member);
            return true;
        }
    }
}

