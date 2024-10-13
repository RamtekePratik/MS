package com.mastercard.demo.demo.configurations.conditional;

import jakarta.annotation.PostConstruct;

public class MyConditionalBean {

    private String name;
    private String age;

    @PostConstruct
    public void initialize()
    {
        this.name = "pratik";
        this.age = "23";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
