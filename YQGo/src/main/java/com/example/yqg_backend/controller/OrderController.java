package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.entity.RequestOrder;
import com.example.yqg_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getOrderByUser",method = RequestMethod.GET)
    public Order getOrderByUser(@RequestParam("userID") Integer userID){
        return null;
    }

    @RequestMapping(value = "/getOrderDetail",method = RequestMethod.GET)
    public Order getOrderDetail(@RequestParam("orderID") Integer orderID){
        return null;
    }

    // goods为对象数组，包括goodsId,count
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public Order addOrder(@RequestBody RequestOrder requestOrder){
        return orderService.addOrder(requestOrder);
        //return true;
    }

    @RequestMapping(value = "/getOrdersByGroupBuy",method = RequestMethod.GET)
    public List<Order> getOrdersByGroupBuy(@RequestParam("GroupBuyID") Integer GBID){
        return null;
    }

    @RequestMapping(value = "/updateOrderStatus",method = RequestMethod.POST)
    public boolean updateOrderStatus(@RequestParam("status") String status){
        return true;
    }
}
