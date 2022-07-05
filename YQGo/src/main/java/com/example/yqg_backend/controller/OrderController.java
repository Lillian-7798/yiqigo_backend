package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getOrderByUser",method = RequestMethod.GET)
    public Order getOrderByUser(@RequestParam("userID") Integer userID){
        return null;
    }

    @RequestMapping(value = "/getOrderByLeader",method = RequestMethod.GET)
    public Map<String, Object> getOrderByLeader(@RequestParam("GroupBuyId") Integer GroupBuyId){
        return orderService.getOrderByLeader(GroupBuyId);
    }

    @RequestMapping(value = "/getOrderDetailByLeader",method = RequestMethod.GET)
    public Map<String,Object> getOrderDetailByLeader(@RequestParam("orderID") Integer orderID){
        return orderService.getOrderDetailByLeader(orderID);
    }

    // goods为对象数组，包括goodsId,count
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public boolean addOrder(@RequestBody List<Object> goods,
                            @RequestParam("userId") Integer userid,
                            @RequestParam("logisticsType") Integer logis,
                            @RequestParam("diliverAddr") String diliverAddr,
                            @RequestParam("receiveAddr") String receiveAddr,
                            @RequestParam("GroupBuyID") Integer GBID,
                            @RequestParam("note") String note){

        return true;
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
