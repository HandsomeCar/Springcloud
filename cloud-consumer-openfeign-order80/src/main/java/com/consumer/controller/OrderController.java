package com.consumer.controller;

import com.consumer.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单控制层
 */
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private PaymentFeignService paymentFeignService;


    /**
     * 测试OpenFeign接口调用
     * @return
     */
    @GetMapping("/index")
    public String get(){
        return paymentFeignService.index();
    }
}

