package com.example.yqg_backend.dao;

import com.example.yqg_backend.entity.User;

public interface UserDao {
<<<<<<< Updated upstream
    User getUser(Integer userId);
=======
    Map<String,Object> getUser(Integer userId);

    User getUserById(Integer userId);

    Map<String,Object> getUserByName(String name);

    Boolean checkUser(String userName,String password);

    Boolean addUser(String userName,String password);

    boolean subscription(Integer lid,Integer mid);
>>>>>>> Stashed changes
}
