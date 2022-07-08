package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.User;
import com.example.yqg_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public Map<String,Object> getUser(@RequestParam("userID") Integer userID)
    {
        return userService.getUser(userID);
    }

    @RequestMapping(value="/checkUser",method=RequestMethod.GET)
    public boolean checkUser(@RequestParam("userName") String userName,@RequestParam("password") String password){
        return userService.checkUser(userName,password);
    }

    @RequestMapping(value = "/getUserByName",method = RequestMethod.GET)
    public Map<String,Object> getUserByName(@RequestParam("userName") String userName)
    {
        return userService.getUserByName(userName);
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public boolean addUser(@RequestBody Map map){
        return userService.addUser((String) map.get("userName"),(String) map.get("password"));
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public boolean updateUseer(@RequestParam("userID") String userID,@RequestParam("address") String address){
        return true;
    }
}
