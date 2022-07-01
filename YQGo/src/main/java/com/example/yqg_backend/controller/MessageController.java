package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.Dialog;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MessageController {
    @RequestMapping(value = "/getDialogsByUser",method = RequestMethod.GET)
    public List<Dialog> getDialogsByUser(@RequestParam("userID") Integer userID){
        return null;
    }

    @RequestMapping(value = "/getDialog",method = RequestMethod.GET)
    public Dialog getDialog(@RequestParam("userId1") Integer userId1, @RequestParam("userId2") Integer userId2){
        return null;
    }

    @RequestMapping(value = "/addDialog",method = RequestMethod.POST)
    public boolean addDialog(@RequestParam("userId1") Integer userId1,@RequestParam("userId2") Integer userId2){
        return true;
    }

    @RequestMapping(value = "/addMessage",method = RequestMethod.POST)
    public boolean addMessage(@RequestParam("dialogId") Integer dialogId,@RequestParam("userId") Integer userId, @RequestParam("content") String content){
        return true;
    }
}
