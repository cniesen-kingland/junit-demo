package com.kingland.cniesen.junitdemo.services;

import com.kingland.cniesen.junitdemo.bo.OurString;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdderService {

    public Integer add(Integer a, Integer b) {
        if (b == null) {
            throw new NullPointerException("b is null");
        }

        System.out.println(">>> AdderService.add used with " + a + " and " + b);
        return a + b;
    }

    public List<OurString> getList() {
        return Arrays.asList(new OurString("Alpha"), new OurString("Beta"), new OurString("Delta"), new OurString("Charly"));
    }

}
