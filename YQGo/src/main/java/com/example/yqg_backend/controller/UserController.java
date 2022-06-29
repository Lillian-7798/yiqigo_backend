package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.Users;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/getUser")
    public Users getUser(@RequestParam("userid") Integer userid)
    {
        return null;
    }
}
