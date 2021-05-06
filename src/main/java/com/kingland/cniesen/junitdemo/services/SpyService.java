package com.kingland.cniesen.junitdemo.services;

public class SpyService {

    private Integer value;

    public SpyService(Integer value) {
        this.value = value;
    }

    public String getANumber() {
        return next("The number is: ");
    }

   protected String next(String text) {
        System.out.println(">>> Doing next");
        value = value + 3;
        return text + value;
    }
}
