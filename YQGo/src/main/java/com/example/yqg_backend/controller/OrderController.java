package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.Orders;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @RequestMapping(value = "/getOrderByUser",method = RequestMethod.GET)
    public Orders getOrderByUser(@RequestParam("userID") Integer userID){
        return null;
    }

    @RequestMapping(value = "/getOrderDetail",method = RequestMethod.GET)
    public Orders getOrderDetail(@RequestParam("orderID") Integer orderID){
        return null;
    }

//    addOrder这里不知道前端的商品列表要怎么传进来
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public boolean addOrder(@RequestParam("goodsList") List<Object> goods,
                            @RequestParam("logisticsType") Integer logis,
                            @RequestParam("diliverAddr") String diliverAddr,
                            @RequestParam("receiveAddr") String receiveAddr,
                            @RequestParam("GroupBuyID") Integer GBID){
        return true;
    }

    @RequestMapping(value = "/getOrdersByGroupBuy",method = RequestMethod.GET)
    public List<Orders> getOrdersByGroupBuy(@RequestParam("GroupBuyID") Integer GBID){
        return null;
    }

    @RequestMapping(value = "/updateOrderStatus",method = RequestMethod.POST)
    public boolean updateOrderStatus(@RequestParam("status") String status){
        return true;
    }
}
