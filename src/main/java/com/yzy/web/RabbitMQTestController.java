package com.yzy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQTestController {

    @RequestMapping("/rabbit")
    public String test(){
        return "123";
    }
}
