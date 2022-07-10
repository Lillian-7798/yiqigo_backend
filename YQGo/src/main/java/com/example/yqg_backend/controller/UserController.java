package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.User;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(@RequestParam("userID") Integer userID)
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

    @RequestMapping(value = "/subscription",method = RequestMethod. GET)
    public boolean subscription(@RequestParam("leader_id") Integer lid,@RequestParam("member_id") Integer mid){
        return userService.subscription(lid,mid);
    }
}
