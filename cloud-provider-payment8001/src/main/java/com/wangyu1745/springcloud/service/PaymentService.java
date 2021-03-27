package com.wangyu1745.springcloud.service;

import com.wangyu1745.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangyu
 * @create 2021/3/25 21:15
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
