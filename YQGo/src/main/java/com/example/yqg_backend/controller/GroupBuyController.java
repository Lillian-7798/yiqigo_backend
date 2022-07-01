package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.Groupbuy;
import com.example.yqg_backend.entity.Order;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin
@RestController
public class GroupBuyController {

    @RequestMapping("/getGroupBuysByUser")
    public List<Groupbuy> getUser(@RequestParam("userid") Integer userid)
    {
        return null;
    }

    @RequestMapping(value = "/getGroupBuyDetail",method = RequestMethod.GET)
    public Groupbuy getGroupBuyDetail(@RequestParam("groupBuyId") Integer groupBuyId){
        return null;
    }

    @RequestMapping(value = "/addGroupBuy",method = RequestMethod.POST)
    public boolean addGroupBuy(@RequestParam("title") String title,
                               @RequestParam("description") String description,
                               @RequestParam("logisticsType") Integer logisticsType,
                               @RequestParam("startTime") Date startTime,
                               @RequestParam("endTime") Date endTime,
                               @RequestParam("isSecKill") Boolean isSecKill){
        return true;
    }

    /* Not Sure Yet */
    @RequestMapping(value = "/updateGroupBuy",method = RequestMethod.POST)
    public boolean updateGroupBuy(@RequestParam("title") String title,
                                  @RequestParam("description") String description,
                                  @RequestParam("logisticsType") Integer logisticsType,
                                  @RequestParam("startTime") Date startTime,
                                  @RequestParam("endTime") Date endTime,
                                  @RequestParam("isSecKill") Boolean isSecKill){
        return true;
    }

    @RequestMapping(value = "/deleteGroupBuy")
    public boolean deleteGroupBuy(@RequestParam("groupBuyId") Integer groupBuyId) {
        return true;
    }

    @RequestMapping("endGroupBuy")
    public boolean endGroupBuy(@RequestParam("groupBuyId") Integer groupBuyId) {
        return true;
    }

    @RequestMapping(value = "/updateGroupBuyInventory")
    public boolean updateGroupBuyInventory(@RequestParam("groupBuyId") Integer groupBuyId) {
        return true;
    }

    @RequestMapping(value = "/getGroupBuyByLeader",method = RequestMethod.GET)
    public List<Order> getGroupBuyByLeader(@RequestParam("userId") Integer userId){
        return null;
    }

    @RequestMapping(value = "/getGroupBuyByGoodsName",method = RequestMethod.GET)
    public List<Order> getGroupBuyByGoodsName(@RequestParam("name") String name){
        return null;
    }

    @RequestMapping(value = "/getGroupBuyStatistics",method = RequestMethod.GET)
    public List<Order> getGroupBuyStatistics(@RequestParam("groupBuyId") Integer groupBuyId){
        return null;
    }
}
