package com.don.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "this is test";
    }

    public static void main(String[] args) {
        SpringApplication.run(TestController.class, args);
    }

}
