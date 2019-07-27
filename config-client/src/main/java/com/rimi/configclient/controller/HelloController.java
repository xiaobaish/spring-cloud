package com.rimi.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @date 2019-07-18 17:55
 */
@RefreshScope
@RestController
public class HelloController {

    @Value("${name}")
    String name;

    @GetMapping("/")
    public String hello(){
        return "你好："+name;
    }
}
