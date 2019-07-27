package com.rimi.serviceribbon.controller;

import com.rimi.serviceribbon.service.IHelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @date 2019-07-17 14:27
 */
@RestController
public class HelloController {

    private final IHelloService helloService;

    public HelloController(IHelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/")
    public String hello(){
        return helloService.hello();
    }
}
