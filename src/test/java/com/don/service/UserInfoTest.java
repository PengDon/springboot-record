package com.don.service;

import com.don.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserInfoTest {
    @Autowired
    private UserInfo userInfo;

    @Test
    public void getTest() throws Exception {
        Assert.assertEquals(userInfo.getName(), "李四");
        Assert.assertEquals(userInfo.getSkill(), "java");

    }

    @Test
    public void getDest() throws Exception {
        System.out.println(userInfo.getDesc());
    }

}