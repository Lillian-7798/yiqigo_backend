package com.example.yqg_backend.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class WebsocketConfiguration {
    int port = 8081;

    @Bean
    public MyWebsocketServer getWebSocketServer() throws Exception {
        MyWebsocketServer server = new MyWebsocketServer(port);
        server.start();
        System.out.println("WebsocketServer started on : ws://localhost:" + port);
        return server;
    }

}

