package com.kingland.cniesen.junitdemo.services;

import com.kingland.cniesen.junitdemo.utilities.FooBarUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mockStatic;

@RunWith(MockitoJUnitRunner.class)
public class StaticServiceTest {
    StaticService staticService = new StaticService();

    @Test
    public void helloTest() {
        try (MockedStatic<FooBarUtil> fooBarUtilMockedStatic = mockStatic(FooBarUtil.class)) {
            fooBarUtilMockedStatic.when(FooBarUtil::getFooBar).thenReturn("World");
            String result = staticService.sayHello();
            assertEquals("Hello World", result);
        }
    }

}