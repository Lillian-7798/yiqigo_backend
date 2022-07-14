package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.entity.RequestOrder;
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
    public List<Map<String, Object>> getOrderByUser(@RequestParam("userID") Integer userID) {
        return orderService.getOrderByUser(userID);
    }

    @RequestMapping(value = "/getOrderDetail",method = RequestMethod.GET)
    public Map<String,Object> getOrderDetail(@RequestParam("orderID") Integer orderID){
        return orderService.getOrderDetail(orderID);
    }

    @RequestMapping(value = "/getOrderByLeader",method = RequestMethod.GET)
    public Map<String, Object> getOrderByLeader(@RequestParam("GroupBuyId") Integer GroupBuyId){
        return orderService.getOrderByLeader(GroupBuyId);
    }

    @RequestMapping(value = "/getOrderDetailByLeader",method = RequestMethod.GET)
    public Map<String,Object> getOrderDetailByLeader(@RequestParam("orderID") Integer orderID){
        return orderService.getOrderDetailByLeader(orderID);
    }

    @RequestMapping(value = "/cancelOrder",method = RequestMethod.GET)
    public boolean cancelOrder(@RequestParam("orderId") Integer orderId){
        if(orderService.cancelOrder(orderId))
            return true;
        return false;
    }

    // RequestOrder为前端发送的请求内容
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public int addOrder(@RequestBody RequestOrder requestOrder){
        return orderService.addOrder(requestOrder);
    }

    @RequestMapping(value = "/Pay")
    public boolean pay(@RequestParam("orderID") Integer orderID){
        return orderService.pay(orderID);
    }

    @RequestMapping(value = "/cancelByUser")
    public boolean cancelByUser(@RequestParam("orderID") Integer orderID){
        return orderService.cancelByUser(orderID);
    }

    // RequestOrder为前端发送的请求内容
    @RequestMapping(value = "/lockOrder",method = RequestMethod.POST)
    public int lockOrder(@RequestBody RequestOrder requestOrder){
        return orderService.lockOrder(requestOrder);
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
