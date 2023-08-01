package com.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 支付远程调用Feign接口
 */
@Component
@FeignClient(value = "cloud-payment-provider")
public interface PaymentFeignService {


    @GetMapping("/payment/index")
    String index();


}

