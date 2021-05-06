package com.kingland.cniesen.junitdemo.services;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplierServiceTest_noMock {
    MultiplierService multiplierService = new MultiplierService(new AdderService());

    @Test
    public void two_times_three() {
        Integer expected = 6;
        Integer result = multiplierService.multiply(2,3);
        assertEquals(expected, result);
    }

}