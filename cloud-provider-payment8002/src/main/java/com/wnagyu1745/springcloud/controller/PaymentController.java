package com.wnagyu1745.springcloud.controller;

import com.wangyu1745.springcloud.entities.CommonResult;
import com.wangyu1745.springcloud.entities.Payment;
import com.wnagyu1745.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wangyu
 * @create 2021/3/25 21:23
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败，serverPort："+serverPort, null);
        }
    }

    @GetMapping("payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果：" + result);
        if (result != null) {
            return new CommonResult(200, "查询成功", result);
        } else {
            return new CommonResult(444, "没有对应记录，查询id" + id, null);
        }
    }

}
