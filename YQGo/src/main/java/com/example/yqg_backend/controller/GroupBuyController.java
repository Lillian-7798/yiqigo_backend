package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.Groupbuy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupBuyController {

    @RequestMapping("/getGroupBuysByUser")
    public Groupbuy getUser(@RequestParam("userid") Integer userid)
    {
        return null;
    }
}
