package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {


    @LoadBalanced  // restTemplate 集成Ribbon组件，进行负载均衡
    @Bean
    public RestTemplate getRest(){
        return new RestTemplate();
    }

}
