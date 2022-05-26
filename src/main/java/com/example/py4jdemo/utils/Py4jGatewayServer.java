package com.example.py4jdemo.utils;

import py4j.GatewayServer;
import py4j.commands.Command;

import java.util.List;

public class Py4jGatewayServer extends GatewayServer {
    public static class GatewayServerBuilder {
        private Object entryPoint = null;
        private int port = 25333;
        private int pythonPort = 25334;

        private int connectTimeout = 0;

        private int readTimeout = 0;
        private List<Class<? extends Command>> customCommands = null;

        public GatewayServerBuilder entryPoint(Object entryPoint) {
            this.entryPoint = entryPoint;
            return this;
        }

        public GatewayServerBuilder port(int port) {
            this.port = port;
            return this;
        }

        public GatewayServerBuilder pythonPort(int pythonPort) {
            this.pythonPort = pythonPort;
            return this;
        }

        public GatewayServerBuilder connectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public GatewayServerBuilder readTimeout(int readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public GatewayServerBuilder customCommands(List<Class<? extends Command>> customCommands) {
            this.customCommands = customCommands;
            return this;
        }

        public GatewayServer build() {
            return new Py4jGatewayServer(entryPoint, port, pythonPort, connectTimeout, readTimeout, customCommands);
        }
    }

    private Py4jGatewayServer(Object entryPoint, int port, int pythonPort, int connectTimeout, int readTimeout, List<Class<? extends Command>> customCommands) {
        super(entryPoint, port, pythonPort, connectTimeout, readTimeout, customCommands);
    }
}