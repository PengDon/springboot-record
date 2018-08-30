package com.don.web;

import com.don.service.UserInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    // 创建线程安全的Map
    static Map<Long, UserInfo> users = Collections.synchronizedMap(new HashMap<Long, UserInfo>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<UserInfo> getUserList(){
        // 获取用户列表
        List<UserInfo> u = new ArrayList<UserInfo>(users.values());
        return u;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String addUser(@ModelAttribute UserInfo userInfo){
        // 添加用户信息
       users.put(userInfo.getId(),userInfo);
       return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public UserInfo getUser(@PathVariable Long id) {
        // 根据id查询用户信息
        return users.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
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

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 根据id删除用户信息
        users.remove(id);
        return "success";
    }
}
