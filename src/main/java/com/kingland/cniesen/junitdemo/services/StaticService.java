package com.kingland.cniesen.junitdemo.services;

import com.kingland.cniesen.junitdemo.utilities.FooBarUtil;

public class StaticService {
    public String sayHello() {
        return "Hello " + FooBarUtil.getFooBar();
    }
}
