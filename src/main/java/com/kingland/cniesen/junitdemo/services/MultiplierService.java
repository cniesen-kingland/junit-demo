package com.kingland.cniesen.junitdemo.services;

import org.springframework.stereotype.Service;

@Service
public class MultiplierService {

    final
    AdderService adderService;

    public MultiplierService(AdderService adderService) {
        this.adderService = adderService;
    }

    public Integer multiply (Integer a, Integer b) {
        int result = 0;
        for(int i = 0; i < b; i++) {
            result = adderService.add(result, a);
        }
        return result;
    }

}
