package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    Integer port;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        try {
            int result = paymentService.create(payment);
            log.info("*****插入结果："+result);
            if (result > 0 ){
                return new CommonResult(200,"插入数据成功",payment);
            }else{
                return new CommonResult(444,"插入数据失败",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("插入数据异常:"+e.getMessage());
            return new CommonResult<>(99999,"插入数据异常="+e.getMessage());
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        try {
            Payment payment = paymentService.getPaymentById(id);
            log.info("*****查询结果："+payment);
            if (payment!=null){  //说明有数据，能查询成功
                return new CommonResult(200,"查询成功:port=" + port,payment);
            }else {
                return new CommonResult(444,"没有对应记录，查询ID："+id,null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("插入数据异常:"+e.getMessage());
            return new CommonResult<>(99999,"插入数据异常="+e.getMessage());
        }
    }

}
