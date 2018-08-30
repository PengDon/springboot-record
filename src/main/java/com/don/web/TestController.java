package com.don.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
// 用模板时不用@RestController注解，因为它默认返回的JSON格式
@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping("/home")
    public String index(ModelMap map) {
        map.addAttribute("home","welcome to home");
        return "index";
    }

    @RequestMapping("/test")
    public String test(){
        return "this is test";
    }
}
