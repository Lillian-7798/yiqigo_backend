package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.Users;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public Users getUser(@RequestParam("userID") Integer userID)
    {
        return null;
    }

    @RequestMapping("/checkUser")
    public boolean checkUser(@RequestParam("userName") String userName,@RequestParam("password") String password){
        return true;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public boolean addUser(@RequestParam("userName") String userName,@RequestParam("password") String password){
        return true;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public boolean updateUseer(@RequestParam("userID") String userID,@RequestParam("address") String address){
        return true;
    }
}
