package com.homeease.notificationservice;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.Transport;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SocketIoConfig {

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname("localhost");
        config.setPort(9093);

        // Configure CORS
        config.setOrigin("*");
//        config.setOrigin("http://localhost:3000");
        config.setTransports(Transport.WEBSOCKET);

        final SocketIOServer server = new SocketIOServer(config);
        server.addConnectListener(client -> {
            log.info("Socket.IO Client: " + client.getSessionId() + " connected");
        });

        server.addDisconnectListener(client -> {
            log.info("Socket.IO Client: " + client.getSessionId() + " disconnected");
        });

        return server;
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketIOServer) {
        return new SpringAnnotationScanner(socketIOServer);
    }
}

