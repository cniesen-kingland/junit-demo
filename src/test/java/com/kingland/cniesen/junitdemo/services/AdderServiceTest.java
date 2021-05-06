package com.kingland.cniesen.junitdemo.services;


import com.kingland.cniesen.junitdemo.bo.OurString;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AdderServiceTest {

    Random random = new Random();

    AdderService adderService = new AdderService();

    @Before
    public void init() {
        // stuff to execute before each test
    }

    @After
    public void teardown() {
        //stuff to execute after each test
    }

    @Test
    public void one_plus_one() {
        Integer expected = 2;
        Integer result = adderService.add(1,1);

        // junit
        assertEquals(expected, result);

        // hamcrest
        assertThat("The result of the multiplier is", result, equalTo(2));
    }

    @Test(expected = NullPointerException.class)
    public void assertNullPointerException() {
        Integer result = adderService.add(1, null);
    }

    @Test
    public void assertExceptionMessage() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> adderService.add(1, null));
        assertEquals("b is null", exception.getMessage());
    }

    @Test
    public void assertList() {
        List<OurString> expected = Arrays.asList(new OurString("Alpha"), new OurString("Beta"), new OurString("Delta"), new OurString("Charly"));
        List<OurString> result = adderService.getList();
        assertEquals(expected, result);
    }

}