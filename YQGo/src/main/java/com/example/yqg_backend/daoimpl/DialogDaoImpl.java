package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.DialogDao;
import com.example.yqg_backend.entity.Dialog;
import com.example.yqg_backend.entity.Message;
import com.example.yqg_backend.entity.User;
import com.example.yqg_backend.repository.DialogRepository;
import com.example.yqg_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.compare;

@Repository
public class DialogDaoImpl implements DialogDao {
    @Autowired
    private DialogRepository dialogRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Map<String, Object>> getDialogsByUser(Integer userID) {
        User user = userRepository.getUserById(userID);
        List<Dialog> dList = user.getDialogs1();
        dList.addAll(user.getDialogs2());
        List<Map<String,Object>> list = new ArrayList<>();

        for(Dialog d : dList) {
            Map<String,Object> map = new HashMap<>();
            User user1 = d.getUserId1();
            User user2 = d.getUserId2();
            if(user1.getId() == userID) {
                map.put("name",user2.getName());
                map.put("userId2", user2.getId());
            } else {
                map.put("name", user1.getName());
                map.put("userId2", user1.getId());
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Timestamp latestTime = d.getLatestDate();
            String time = formatter.format(latestTime);
            map.put("time",time);
            map.put("timeOrder",d.getLatestDate());
            List<Message> mesList = d.getMessages();
            String content = mesList.get(mesList.size()-1).getContent();
            if(content.length() > 15) {
                content = content.substring(0,14);
                content = content + "...";
            }
            map.put("content", content);
            map.put("dialogId",d.getId());

            list.add(map);
        }

        List<Map<String,Object>> rList = list.stream().sorted((e1,e2)->{
            if(!e1.containsKey("timeOrder")) {
                e1.put("timeOrder", "1900-00-00T00:00:00.000+08:00");
            }
            if(!e2.containsKey("timeOrder")) {
                e2.put("timeOrder", "1900-00-00T00:00:00.000+08:00");
            }
            return -compare((Timestamp)e1.get("timeOrder"),(Timestamp) e2.get("timeOrder"));

        }).collect(Collectors.toList());

        int id = 0;
        for(Map<String,Object> map : rList) {
            id += 1;
            map.put("id", id);
        }

        return rList;
    }

    public int compare(Timestamp t1, Timestamp t2) {
        try {
            if (t1.getTime() > t2.getTime()) {
                return 1;
            } else if (t1.getTime() < t2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
