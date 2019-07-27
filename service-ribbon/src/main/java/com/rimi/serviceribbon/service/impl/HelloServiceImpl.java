package com.rimi.serviceribbon.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rimi.serviceribbon.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @date 2019-07-17 14:22
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "error")
    public String hello() {
        return restTemplate.getForObject("http://EUREKA-CLI/", String.class);
    }

    public String error(){
        return "请求错误";
    }
}
