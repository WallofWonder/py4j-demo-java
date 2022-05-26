package com.example.py4jdemo.service;

import com.example.py4jdemo.utils.operators.Addition;
import com.example.py4jdemo.utils.operators.OperatorTest;
import org.springframework.stereotype.Service;
import py4j.ClientServer;

import java.util.List;

@Service
public class OperatorService {

//    @Resource(name = "gatewayServer")
//    GatewayServer server;

    public int doAddition(int x, int y) {
        ClientServer clientServer = new ClientServer.ClientServerBuilder().pythonPort(25337).build();

        Addition addition = (Addition) clientServer.getPythonServerEntryPoint(new Class[]{Addition.class});
        int res = 0;
        try {
            res = addition.add(x, y);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            clientServer.shutdown();
        }
        return res;
    }

    public Object OperatorTest(List<Integer> data) {
//        GatewayServer server = new GatewayServer
//                .GatewayServerBuilder()
//                .callbackClient(22536, GatewayServer.defaultAddress())
//                .build();
//        Average average = (Average) server.getPythonServerEntryPoint(new Class[]{Average.class});
//        ClientServer clientServer = new ClientServer(25333,
//                GatewayServer.defaultAddress(), 25336,
//                GatewayServer.defaultAddress(),
//                0, 0,
//                ServerSocketFactory.getDefault(),
//                SocketFactory.getDefault(), null);
        ClientServer clientServer = new ClientServer.ClientServerBuilder().pythonPort(25336).build();
        Object obj = clientServer.getPythonServerEntryPoint(new Class[]{OperatorTest.class, Addition.class});

        OperatorTest operatorTest = (OperatorTest) obj;
        Addition addition = (Addition) obj;

        List<Integer> listResult = null;
        int addResult = 0;

        try {
            listResult = operatorTest.test(data);
            addResult = addition.add(1, 2);
            System.out.println("处理完成：" + addResult + " " + listResult);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            clientServer.shutdown();
        }
        return listResult;
    }
}
