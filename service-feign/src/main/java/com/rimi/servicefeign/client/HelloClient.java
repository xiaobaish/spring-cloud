package com.rimi.servicefeign.client;

import com.rimi.servicefeign.client.hystrix.HystrixHelloClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author admin
 * @date 2019-07-17 15:12
 */
@FeignClient(value = "EUREKA-CLI", fallback = HystrixHelloClient.class)
public interface HelloClient {

    @GetMapping(value = "/")
    String hello();
}
