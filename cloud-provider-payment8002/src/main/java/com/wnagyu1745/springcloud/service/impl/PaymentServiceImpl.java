package com.wnagyu1745.springcloud.service.impl;

import com.wangyu1745.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import com.wnagyu1745.springcloud.dao.PaymentDao;
import com.wnagyu1745.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author wangyu
 * @create 2021/3/25 21:16
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
