package com.kingland.cniesen.junitdemo.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MultiplierServiceTest_withMock {

    @Mock
    private AdderService adderService;

    @InjectMocks
    MultiplierService multiplierService;

    /**
     * No when..thenReturn specified, the mock still works
     * by returning the default values
     */
    @Test
    public void what_happened_here() {
        Integer expected = 0;
        Integer result = multiplierService.multiply(2,3);
        assertEquals(expected, result);
    }

    @Test
    public void two_times_three() {
        when(adderService.add(0, 2)).thenReturn(2);
        when(adderService.add(2, 2)).thenReturn(4);
        when(adderService.add(4, 2)).thenReturn(6);
        Integer expected = 6;
        Integer result = multiplierService.multiply(2,3);
        assertEquals(expected, result);

        verify(adderService, times(3)).add(anyInt(), anyInt());

        verify(adderService, times(1)).add(0, 2);
        verify(adderService, times(1)).add(2, 2);
        verify(adderService, atMost(1)).add(4, 2);

        verifyNoMoreInteractions(adderService);
    }

}