package com.example.yqg_backend.websocket;

import com.example.yqg_backend.entity.Dialog;
import com.example.yqg_backend.entity.Message;
import com.example.yqg_backend.repository.DialogRepository;
import com.example.yqg_backend.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageReceivingOperations;
import springfox.documentation.spring.web.json.Json;

import java.net.InetSocketAddress;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MyWebsocketServer extends WebSocketServer {

    Map<WebSocket,String> connMap = new ConcurrentHashMap<>();
    Map<WebSocket,String> userIdMap = new ConcurrentHashMap<>();
    Map<WebSocket,String> anoUserIdMap = new ConcurrentHashMap<>();

    @Autowired
    DialogRepository dialogRepository;

    @Autowired
    MessageRepository messageRepository;

    public MyWebsocketServer(int port){
        super(new InetSocketAddress(port));
    }

    int n = 0;

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake){
        String resource = conn.getResourceDescriptor();
        System.out.println(resource);
        String dialogId = HttpUtils.getParameter(resource, "dialogId");
        String userId = HttpUtils.getParameter(resource, "userId");
        String anoUserId = HttpUtils.getParameter(resource, "anoUserId");
        System.out.println(dialogId+' '+userId+' '+anoUserId);

        connMap.put(conn,dialogId);
        userIdMap.put(conn,userId);
        anoUserIdMap.put(conn,anoUserId);

        System.out.println(dialogId+" 连接 Websocket, 总连接数 = "+connMap.size());

        List<Message> messageList = messageRepository.getMessageByDiaId(Integer.valueOf(dialogId));
        for(Message message:messageList){
//            System.out.println("mess"+message.getId().toString());
            String initMess = message.getUserId().toString()+'\n'+message.getContent();
//            System.out.println(initMess);
            conn.send(initMess);
        }
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        String name = connMap.remove(conn);
        System.out.println(name+" 断开 websocket");
        userIdMap.remove(conn);
        anoUserIdMap.remove(conn);
    }
    @Override
    public void onMessage(WebSocket conn, String message){
        String dialogId = connMap.get(conn);
        String userId = userIdMap.get(conn);
        String anoUserId = anoUserIdMap.get(conn);
        System.out.println("u"+userId);

        connMap.forEach((webSocket, s) -> {
            if(webSocket!=conn&&s.equals(dialogId)){
                System.out.println(userId+'\n'+message);
                webSocket.send(userId+'\n'+message);
            }
        });
        Dialog dialog = dialogRepository.getDialogById(Integer.valueOf(dialogId)).get(0);
        dialog.setLatestDate(new Timestamp(System.currentTimeMillis()));
        dialogRepository.save(dialog);
        Message message1 = new Message();
        message1.setContent(message);
        message1.setDialog(dialog);
        message1.setUserId(Integer.valueOf(userId));
        messageRepository.save(message1);
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {

    }

    @Override
    public void onStart() {
        System.out.println("ws start http://localhost:"+getAddress().getPort());
    }
}
