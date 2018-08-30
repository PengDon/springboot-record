package com.don.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {

    @ApiOperation(value="首页", notes="")
    @RequestMapping("/home")
    public String index(ModelMap map) {
        map.addAttribute("home","welcome to home");
        return "index";
    }

    @ApiOperation(value="测试", notes="")
    @RequestMapping("/test")
    public String test(){
        return "this is test";
    }
}
