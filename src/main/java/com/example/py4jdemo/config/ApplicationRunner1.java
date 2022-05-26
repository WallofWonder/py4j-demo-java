package com.example.py4jdemo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import py4j.GatewayServer;

import javax.annotation.Resource;

@Component
public class ApplicationRunner1 implements ApplicationRunner {
//    @Resource(name = "gatewayServer")
//    GatewayServer server;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // server.start();
    }
}