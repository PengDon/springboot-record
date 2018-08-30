package com.don.web;

import com.don.service.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    // 创建线程安全的Map
    static Map<Long, UserInfo> users = Collections.synchronizedMap(new HashMap<Long, UserInfo>());

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<UserInfo> getUserList(){
        // 获取用户列表
        List<UserInfo> u = new ArrayList<UserInfo>(users.values());
        return u;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String addUser(@ModelAttribute UserInfo userInfo){
        // 添加用户信息
       users.put(userInfo.getId(),userInfo);
       return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public UserInfo getUser(@PathVariable Long id) {
        // 根据id查询用户信息
        return users.get(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateUser(@PathVariable Long id, @ModelAttribute UserInfo userInfo){
        // 根据id更新用户信息
        UserInfo u = users.get(id);
        u.setName(userInfo.getName());
        u.setSkill(userInfo.getSkill());
        u.setDesc(userInfo.getDesc());
        users.put(id,u);

        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 根据id删除用户信息
        users.remove(id);
        return "success";
    }
}
