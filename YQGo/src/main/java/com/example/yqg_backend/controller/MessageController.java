package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.Dialog;
import com.example.yqg_backend.service.DialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class MessageController {
    @Autowired
    private DialogService dialogService;

    @RequestMapping(value = "/getDialogsByUser",method = RequestMethod.GET)
    public List<Map<String, Object>> getDialogsByUser(@RequestParam("userID") Integer userID){
        return dialogService.getDialogsByUser(userID);
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
