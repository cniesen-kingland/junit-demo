package com.kingland.cniesen.junitdemo.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SpyServiceTest {

    @Spy
    SpyService spyService = new SpyService(4);


    @Test
    public void lets_spy() {
        String result = spyService.getANumber();
        assertEquals("The number is: 7", result);
        verify(spyService, times(1)).next("The number is: ");
        reset(spyService);

        result = spyService.getANumber();
        assertEquals("The number is: 10", result);
        verify(spyService, times(1)).next("The number is: ");

    }

    @Test
    public void lets_stub_with_spy_the_wrong_way() {
        when(spyService.next(anyString())).thenReturn("Hello there");
        String result = spyService.getANumber();
        assertEquals("Hello there", result);
        verify(spyService, times(1)).next("The number is: ");
    }

    @Test
    public void lets_stub_with_spy() {
        doReturn("Hello there").when(spyService).next(anyString());
        String result = spyService.getANumber();
        assertEquals("Hello there", result);
        verify(spyService, times(1)).next("The number is: ");
    }
}