package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.GroupBuyDao;
import com.example.yqg_backend.entity.*;
import com.example.yqg_backend.repository.*;
import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class GroupBuyDaoImpl implements GroupBuyDao {
    @Autowired
    private GroupbuyRepository groupbuyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private GroupbuyitemRepository groupbuyitemRepository;

    @Override
    public List<Map<String, Object>> getUserGB(Integer uid) {
        User u = userRepository.getById(uid);
        List<Groupbuy> list = groupbuyRepository.findByUserId(u);

        List<Map<String, Object>> rList = new ArrayList<>();

        for (Groupbuy gb: list) {
            String title = gb.getTitle();
            Integer GroupBuyId = gb.getId();
            Integer sta = gb.getStatus();
            Timestamp startTime = gb.getStartTime();
            Timestamp endTime = gb.getEndTime();
            Timestamp current = new Timestamp(System.currentTimeMillis());
            String status = "已结束";
            if(sta == 0)
                status = "提前结束";
            else if(endTime.getTime() >= current.getTime() && sta==1)
                status = "正在抢购中";
            else if(startTime.getTime() > current.getTime() && sta==1)
                status = "未开始";
            else if(sta==2)
                status = "已删除";

            List<Groupbuyitem> listGoods = gb.getGroupbuyitems();
            List<String> url = new ArrayList<>();
            int minPrice = 10000;
            for(Groupbuyitem gbi : listGoods) {
                Good g = gbi.getGoods();
                int price = g.getPrice();
                String image = g.getImages();
                if(price <= minPrice)
                    minPrice = price;
                url.add(image);
            }

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("GroupBuyId", GroupBuyId);
            map.put("title", title);
            map.put("price", minPrice);
            map.put("status", status);
            map.put("urls", url);
            rList.add(map);
        }
        return rList;
    }

    @Override
    public Map<String, Object> getGroupBuyDetail(Integer groupBuyId,Integer userId) {
        Map<String, Object> map = new HashMap<String, Object>();

        Groupbuy gb = groupbuyRepository.findByGroupBuyId(groupBuyId);
        map.put("storeName",gb.getUser().getName());
        map.put("storeId",gb.getUser().getId());
        map.put("groupName", gb.getTitle());
        map.put("loType", gb.getLogisticsType());
        /*
        Integer loType = gb.getLogisticsType();
        String mode = "用户自提";   //loType == 0
        if(loType == 1)
            mode = "国内物流";
        else if(loType == 2)
            mode = "国际物流";
        map.put("mode", mode);
        */

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp startTime = gb.getStartTime();
        String fStartTime = formatter.format(startTime);
        String st = "开始时间: "+fStartTime;
        Timestamp endTime = gb.getEndTime();
        String fEndTime = formatter.format(endTime);
        String et = "结束时间: "+fEndTime;
        map.put("start_time", st);
        map.put("end_time", et);

        map.put("description", gb.getDescription());

        List<Groupbuyitem> gbiList = gb.getGroupbuyitems();
        List<Map<String, Object>> goods_list = new ArrayList<>();
        for(Groupbuyitem gbi : gbiList) {
            Map<String, Object> m = new HashMap<String, Object>();
            Good g = gbi.getGoods();
            m.put("goodsId", g.getId());
            m.put("name", g.getName());
            m.put("image", g.getImages());
            m.put("price", g.getPrice());
            m.put("inventory",gbi.getInventory());
            Integer number = 0;
            m.put("number", number);
            goods_list.add(m);
        }
        map.put("goods_list", goods_list);
        for(User user:gb.getUser().getMembers()){
            if(user.getId()==userId) {
                map.put("issubscription", true);
                return map;
            }
        }
        map.put("issubscription",false);
        return map;
    }

    @Override
    public List<Map> searchGB(String keyword,String searchBy){
        if(searchBy.equals("团长名")){
//            System.out.println(1);
            String key="%"+keyword+"%";
            List<Groupbuy> groupbuys=groupbuyRepository.getGBByuserName(key);
            List<Map> GBs = new ArrayList<>();
            for(Groupbuy item:groupbuys){
                Map<String, Object> map = new HashMap<String, Object>();
                Integer price =new Integer(1000);
                map.put("id",item.getId());
                map.put("username",item.getUser().getName());
                map.put("title",item.getTitle());
                List<String> url=new ArrayList<>();
                for(Groupbuyitem it:item.getGroupbuyitems()){
                    url.add(it.getGoods().getImages());
                    if(it.getGoods().getPrice()<price){
                        price=it.getGoods().getPrice();
                    }
                }
                map.put("price",price);
                map.put("urls",url);
                GBs.add(map);
            }
            return GBs;
        }
//       if(searchBy=="商品名称")
        else{
//            System.out.println(searchBy);
            List<Groupbuy> groupbuys=new ArrayList<>();
            //获取GroupBuyList
            for(Groupbuy temp:groupbuyRepository.getGroupbuys()){
                for(Groupbuyitem it:temp.getGroupbuyitems()){
                    if(it.getGoods().getName().indexOf(keyword)>-1){
                        groupbuys.add(temp);
                        break;
                    }
                }
            }
            List<Map> GBs = new ArrayList<>();
            for(Groupbuy item:groupbuys){
                Map<String, Object> map = new HashMap<String, Object>();
                Integer price =new Integer(200);
                map.put("id",item.getId());
                map.put("username",item.getUser().getName());
                map.put("title",item.getTitle());
                List<String> url=new ArrayList<>();
                for(Groupbuyitem it:item.getGroupbuyitems()){
                    url.add(it.getGoods().getImages());
                    if(it.getGoods().getPrice()<price){
                        price=it.getGoods().getPrice();
                    }
                }
                map.put("price",price);
                map.put("urls",url);
                GBs.add(map);
            }
            return GBs;
        }
    }
    @Override
    public Groupbuy getGroupBuy(Integer groupBuyId) {
        return groupbuyRepository.getById(groupBuyId);
    }

    @Override
    public boolean deleteGroupBuy(Integer groupBuyId) {
        Groupbuy gb = groupbuyRepository.findByGroupBuyId(groupBuyId);
        if(gb.getStatus() != 2) {
            gb.setStatus(2);
            List<Order> lo = gb.getOrders();
            for(Order o : lo) {
                if(o.getStatus()!= 3) {
                    o.setStatus(3);
                    User u = o.getUser();
                    u.setMoney(u.getMoney()+o.getPrice());
                    userRepository.save(u);
                    orderRepository.save(o);
                }
            }
            groupbuyRepository.save(gb);
            return true;
        }
        return false;
    }

    @Override
    public boolean earlyEnd(Integer groupBuyId) {
        Groupbuy gb = groupbuyRepository.findByGroupBuyId(groupBuyId);
        if(gb.getStatus() == 1) {
            gb.setStatus(0);
            groupbuyRepository.save(gb);
            return true;
        }
       return false;
    }

    @Override
    public Map<String, Object> getGroupBuyInfo(Integer groupBuyId) {
        Groupbuy gb = groupbuyRepository.findByGroupBuyId(groupBuyId);
        Map<String ,Object> rMap = new HashMap<>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp startTime = gb.getStartTime();
        Timestamp endTime = gb.getEndTime();
        String startDate = formatter.format(startTime);
        String endDate = formatter.format(endTime);

        List<Map<String,Object>> goods = new ArrayList<>();
        List<Groupbuyitem> gbiList = gb.getGroupbuyitems();
        for(Groupbuyitem gbi : gbiList) {
            Map<String, Object> map = new HashMap<>();
            Good g = gbi.getGoods();
            map.put("name",g.getName());
            map.put("goods_des",g.getDescription());
            List<String> image = new ArrayList<>();
            image.add(g.getImages());
            map.put("image",image);
            map.put("selling_price",g.getPrice());
            map.put("inventory",gbi.getInventory());
            map.put("cost_price",gbi.getCost());
            map.put("iskill",gbi.getIsSecKill());
            goods.add(map);
        }
        rMap.put("title",gb.getTitle());
        rMap.put("description",gb.getDescription());
        rMap.put("curNow",gb.getLogisticsType());
        rMap.put("startDate",startDate);
        rMap.put("endDate",endDate);
        rMap.put("goods",goods);
        return rMap;
    }

    @Override
    public boolean ModifyGroupBuy(ModifiedGroupBuy modifiedGroupBuy) {
        Groupbuy groupbuy = groupbuyRepository.findByGroupBuyId(modifiedGroupBuy.getGroupBuyId());
        groupbuy.setTitle(modifiedGroupBuy.getTitle());
        groupbuy.setDescription(modifiedGroupBuy.getDescription());
        groupbuy.setLogisticsType(modifiedGroupBuy.getLogisticsType());
        groupbuy.setStartTime(Timestamp.valueOf(modifiedGroupBuy.getStartTime()));
        groupbuy.setEndTime(Timestamp.valueOf(modifiedGroupBuy.getEndTime()));

        List<Groupbuyitem> gbiList = groupbuy.getGroupbuyitems();    //将原有的GroupBuyItem和goods删除
        for(Groupbuyitem gbi: gbiList) {
            Good g = gbi.getGoods();
            groupbuyitemRepository.delete(gbi);
            goodRepository.delete(g);
        }
        List<Groupbuyitem> groupbuyitems = new ArrayList<>();
        List<ModifiedGoods> goodslist = modifiedGroupBuy.getGoodList();

        for(ModifiedGoods item:goodslist){
            Good good = new Good(item.getName(),item.getGoods_des(),item.getSelling_price(),item.getImage().get(0));
            goodRepository.save(good);
            groupbuyitems.add(new Groupbuyitem(good,item.getInventory(),item.getCost_price(),item.isIskill()));
        }
        for(Groupbuyitem gbi:groupbuyitems){
            gbi.setId(new GroupbuyitemId(groupbuy.getId(),gbi.getGoods().getId()));
            gbi.setGroupBuy(groupbuy);
        }
        groupbuyitemRepository.saveAll(groupbuyitems);

        return true;
    }
    
    @Override
    public void addGroupbuy(Groupbuy groupbuy){groupbuyRepository.save(groupbuy);}

    @Override
    public List<Map> getIndexGB(Integer userId){
        List<Map> re = new ArrayList<>();
        User user = userRepository.getUserById(userId);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        //先获取订阅的团购信息,考虑到可能存在大量信息的问题，这里只获取未结束的团购
        for(User leaders:user.getLeaders()){
            for (Groupbuy groupbuy:leaders.getGroupbuys()){
                if(groupbuy.getStatus()!=0&&groupbuy.getEndTime().getTime()>now.getTime()){
                    Map<String,Object> map = new HashMap<>();
                    map.put("id",groupbuy.getId());
                    map.put("user_id",groupbuy.getUser().getId());
                    map.put("username",groupbuy.getUser().getName());
                    map.put("title",groupbuy.getTitle());
                    map.put("issubscription",true);
                    if(groupbuy.getStartTime().getTime()>now.getTime()) map.put("status","正在抢购中");
                    else{map.put("status","未开始");}
                    Integer price = 1000;
                    List<String> url=new ArrayList<>();
                    for(Groupbuyitem it:groupbuy.getGroupbuyitems()){
                        url.add(it.getGoods().getImages());
                        if(it.getGoods().getPrice()<price){
                            price=it.getGoods().getPrice();
                        }
                    }
                    map.put("urls",url);
                    map.put("price",price);
                    re.add(map);
                }
            }
        }
        return re;
    }
}
