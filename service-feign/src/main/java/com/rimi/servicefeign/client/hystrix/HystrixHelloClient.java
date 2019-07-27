package com.rimi.servicefeign.client.hystrix;

import com.rimi.servicefeign.client.HelloClient;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2019-07-17 15:39
 */
@Component
public class HystrixHelloClient implements HelloClient {
    @Override
    public String hello() {
        return "出错了";
    }
}
