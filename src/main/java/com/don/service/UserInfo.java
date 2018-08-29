package com.don.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserInfo {
    @Value("${com.don.user.name}")
    public String name;
    @Value("${com.don.user.skill}")
    public String skill;
    @Value("${com.don.user.desc}")
    public String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
