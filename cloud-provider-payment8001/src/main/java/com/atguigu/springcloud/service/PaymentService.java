package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {

    public int create(Payment payment);  // 添加

    public Payment getPaymentById(Long id); // 读取

}
