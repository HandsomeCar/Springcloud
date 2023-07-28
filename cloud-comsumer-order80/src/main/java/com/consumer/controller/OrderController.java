package com.consumer.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("order")
public class OrderController {

    @Autowired
    //服务发现
    private DiscoveryClient discoveryClient;

    //  HTTP 请求工具
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 服务发现获取列表
     * @return
     */
    @GetMapping("discovery")
    public Object discovery(){
        // 获取所有微服务信息
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("server:={}",service);
        }
        return this.discoveryClient;
    }

    /**
     * 测试服务发现接口
     * @return
     */
    @GetMapping("/index")
    public String index(){
        //1.远程调用方法的主机
        //Stringhost="http://localhost:1000";
        //将远程微服务调用地址从"IP地址+端口号改成"微服务名称""
        String host = "http://cloud-payment-provider";
        // 2. 远程调用方法具体URL地址
        String url = "/payment/index";
        // 3. 发起远程调用
        //getForObject：返回响应体中数据转化成的对象，可以理解为json
        //getForEntity：返回的是ResponseEntity的对象包含了一些重要的信息
        String forObject = restTemplate.getForObject(host + url, String.class);
        return forObject;
    }
}
