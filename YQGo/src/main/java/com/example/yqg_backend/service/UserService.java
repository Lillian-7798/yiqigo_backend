package com.example.yqg_backend.service;


public interface UserService {
<<<<<<< Updated upstream
=======
    Map<String,Object> getUser(Integer userID);

    Map<String,Object> getUserByName(String name);

    Boolean checkUser(String userName,String password);

    Boolean addUser(String userName,String password);
    boolean subscription(Integer lid,Integer mid);
>>>>>>> Stashed changes
}
