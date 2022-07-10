package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.GroupBuyDao;
import com.example.yqg_backend.entity.Good;
import com.example.yqg_backend.entity.Groupbuy;
import com.example.yqg_backend.entity.Groupbuyitem;
import com.example.yqg_backend.entity.User;
import com.example.yqg_backend.repository.GroupBuyRepository;
import com.example.yqg_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class GroupBuyDaoImpl implements GroupBuyDao {
    @Autowired
    private GroupBuyRepository groupbuyRepository;

    @Autowired
    private UserRepository userRepository;

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
    public Map<String, Object> getGroupBuyDetail(Integer groupBuyId) {
        Map<String, Object> map = new HashMap<String, Object>();

        Groupbuy gb = groupbuyRepository.findByGroupBuyId(groupBuyId);
        map.put("storeName",gb.getUser().getName());
        map.put("groupName", gb.getTitle());

        Integer loType = gb.getLogisticsType();
        String mode = "用户自提";   //loType == 0
        if(loType == 1)
            mode = "国内物流";
        else if(loType == 2)
            mode = "国际物流";
        map.put("mode", mode);

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
            m.put("name", g.getName());
            m.put("image", g.getImages());
            m.put("price", g.getPrice());
            Integer number = 0;
            m.put("number", number);
            goods_list.add(m);
        }
        map.put("goods_list", goods_list);
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
    public void addGroupbuy(Groupbuy groupbuy){groupbuyRepository.save(groupbuy);}
}
