package com.homeease.notificationservice;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SocketServerInitializer implements CommandLineRunner, DisposableBean {

    @Autowired
    private SocketIOServer server;

    @Override
    public void run(String... args) throws Exception {
        server.start();
        log.info("Socket.IO server started");
    }

    @Override
    public void destroy() throws Exception {
        server.stop();
        log.info("Socket.IO server stopped");
    }
}

