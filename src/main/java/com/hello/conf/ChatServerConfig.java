package com.hello.conf;

import com.corundumstudio.socketio.SocketIOServer;
import com.hello.chat.msg.Message;
import com.hello.chat.msg.MessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lex on 2016/12/9.
 */
@Configuration
public class ChatServerConfig {
    @Bean
    public SocketIOServer chatServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();

        config.setPort(9092);

        SocketIOServer server = new SocketIOServer(config);

        server.addEventListener("send_message",
                Message.class,
                new MessageListener(server)
        );

        server.start();
        return server;
    }
}
