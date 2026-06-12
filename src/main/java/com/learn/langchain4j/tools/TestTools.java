package com.learn.langchain4j.tools;

import org.springframework.stereotype.Component;

import dev.langchain4j.agent.tool.Tool;

@Component
public class TestTools {

    @Tool("Get classes")
    public String getUserClass(String userName) {
        System.out.println("------" + userName);
        return null;
    }

    @Tool("Get weather")
    public String getWeather(String address) {
        System.out.println("------" + address);
        return null;
    }
}
