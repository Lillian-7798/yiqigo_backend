package com.example.yqg_backend.controller;

import com.example.yqg_backend.entity.Order;
<<<<<<< HEAD
import com.example.yqg_backend.entity.RequestGoods2;
import com.example.yqg_backend.entity.RequestGroupBuy;
=======
>>>>>>> d4f1cdb6e7680c71f6205382fbec84376c4bc86e
import com.example.yqg_backend.service.GroupBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class GroupBuyController {
    @Autowired
    private GroupBuyService groupBuyService;

    @Autowired
    private GroupBuyService groupBuyService;
    @RequestMapping("/getGroupBuysByUser")
    public List<Map<String, Object>> getUserGB(@RequestParam("userId") Integer userId)
    {
        return groupBuyService.getUserGB(userId);
    }

    @RequestMapping(value = "/getGroupBuyDetail",method = RequestMethod.GET)
    public Map<String, Object> getGroupBuyDetail(@RequestParam("groupBuyId") Integer groupBuyId){
        return groupBuyService.getGroupBuyDetail(groupBuyId);
    }

    @RequestMapping(value = "/addGroupBuy",method = RequestMethod.POST)
    public boolean addGroupBuy(@RequestBody RequestGroupBuy requestGroupBuy){
        System.out.println("add GroupBuy!");
        Timestamp startTime =Timestamp.valueOf(requestGroupBuy.getStartTime());
        Timestamp endTime = Timestamp.valueOf(requestGroupBuy.getEndTime());
        groupBuyService.addGroupBuy(requestGroupBuy.getUserid(), requestGroupBuy.getTitle(),requestGroupBuy.getDescription(),requestGroupBuy.getLogisticsType()
                ,startTime,endTime,requestGroupBuy.getGoodList());
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
