package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;

@Repository
public interface PaymentDao {


    public int create(Payment payment);

    public Payment getPaymentById(@PathParam("id") Long id);

}
