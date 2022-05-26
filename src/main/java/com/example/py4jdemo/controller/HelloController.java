package com.example.py4jdemo.controller;

import com.example.py4jdemo.resource.AdditionReq;
import com.example.py4jdemo.resource.ListReq;
import com.example.py4jdemo.service.OperatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource(name = "operatorService")
    OperatorService operatorService;

    @PostMapping("add")
    public Integer doAddition(@RequestBody AdditionReq req) {
        return operatorService.doAddition(req.getX(), req.getY());
    }

    @PostMapping("func")
    public Object doAvg(@RequestBody ListReq req) {
        return operatorService.OperatorTest(req.getDataList());
    }
}
