package com.rimi.servicefeign.controller;

import com.rimi.servicefeign.client.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @date 2019-07-17 15:16
 */
@RestController
public class HelloController {

    @Autowired
    private HelloClient helloClient;

    @GetMapping("/")
    public String hello(){
        return helloClient.hello();
    }
}
