package com.example.yqg_backend.controller;

import com.example.yqg_backend.config.UploadUtils;
import com.example.yqg_backend.entity.ModifiedGroupBuy;
import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.entity.RequestGroupBuy;
import com.example.yqg_backend.service.GroupBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class GroupBuyController {
    @Autowired
    private GroupBuyService groupBuyService;

    @RequestMapping("/getGroupBuysByUser")
    public List<Map<String, Object>> getUserGB(@RequestParam("userId") Integer userId)
    {
        return groupBuyService.getUserGB(userId);
    }

    @RequestMapping(value = "/getGroupBuyDetail",method = RequestMethod.GET)
    public Map<String, Object> getGroupBuyDetail(@RequestParam("groupBuyId") Integer groupBuyId,@RequestParam("userId") Integer userId){
        return groupBuyService.getGroupBuyDetail(groupBuyId,userId);
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

    @RequestMapping(value = "/deleteGroupBuy")
    public boolean deleteGroupBuy(@RequestParam("groupBuyId") Integer groupBuyId) {
        if(groupBuyService.deleteGroupBuy(groupBuyId))
            return true;
        return false;
    }

    @RequestMapping(value = "/getGroupBuyInfo",method = RequestMethod.GET)
    public Map<String, Object> getGroupBuyInfo(@RequestParam("GroupBuyId") Integer GroupBuyId){
        return groupBuyService.getGroupBuyInfo(GroupBuyId);
    }

    @RequestMapping(value = "/ModifyGroupBuy",method = RequestMethod.POST)
    public boolean ModifyGroupBuy(@RequestBody ModifiedGroupBuy modifiedGroupBuy)
    {
        if(groupBuyService.ModifyGroupBuy(modifiedGroupBuy))
            return true;
        return false;
    }

    @RequestMapping(value = "/earlyEnd")
    public boolean earlyEnd(@RequestParam("groupBuyId") Integer groupBuyId) {
        if(groupBuyService.earlyEnd(groupBuyId))
            return true;
        return false;
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

    @RequestMapping(value = "/searchGB",method = RequestMethod.GET)
    public List<Map> searchGB(@RequestParam("keyword") String keyword,@RequestParam("searchBy") String searchBy){
//        System.out.println("search GB!");
        return groupBuyService.searchGB(keyword,searchBy   );}

    @RequestMapping(value = "getIndexGB",method = RequestMethod.GET)
    public List<Map> getIndexGB(@RequestParam("userId") Integer userId){
//        System.out.println("getIndexGB");
        return groupBuyService.getIndexGB(userId);
    }

    @RequestMapping("/api/uploadImage")
    public static String uploadImg(HttpServletRequest request, @RequestParam("file") MultipartFile[] files){
//        System.out.println(files.length);
        return UploadUtils.upload(files[0]);
    }

    @RequestMapping("/api/deleteImg")
    public boolean deleteImg(@RequestParam("url") String url){
        UploadUtils uploadUtils = new UploadUtils();
        return uploadUtils.delete(url);
    }
}
