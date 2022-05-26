package com.example.py4jdemo;

import com.example.py4jdemo.utils.Py4jGatewayServer;
import com.example.py4jdemo.utils.operators.PingPlayer;
import com.example.py4jdemo.utils.operators.PongPlayer;
import py4j.GatewayServer;

public class ExampleApplication {

    public static void main(String[] args) {
        PingPlayer pingPlayer = new PingPlayer();
        GatewayServer server = new GatewayServer(pingPlayer);
        server.start(true);
    }
}
