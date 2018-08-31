package com.don.web;

import com.don.exception.MyException;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TestController {

    @ApiOperation(value="首页", notes="")
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.addAttribute("home","welcome to home");
        return "index";
    }

    @ApiOperation(value="测试", notes="")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "this is test";
    }

    @ApiOperation(value="默认异常处理", notes="")
    @RequestMapping(value = "/jmm",method = RequestMethod.GET)
    public String jmm() throws Exception{
       throw new Exception("发生错误");
    }

    @ApiOperation(value="自定义异常处理", notes="")
    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @ApiOperation(value="登录", notes="")
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
