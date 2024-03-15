package org.lwason.sbprj.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.Test;

import java.util.Random;

public class RandomMockTest {

    /** Shorthand for mocks creation - using @Mock annotation */
    @Mock
    private Random random;

    @BeforeEach
    void setUp() {
    }

    @Test
    void randomTest01() {
        /** Avoid repetitive mock creation by declaring mock as annotated field  */
        // Random random = Mockito.mock(Random.class);

        /** @Mock fields MUST */
        MockitoAnnotations.openMocks(this);

        /** Always print 0, why? mock is not real object method call, return 'Return Type' default value */
        System.out.println(random.nextInt());
        /** Unless it's stubbed */
        System.out.println(Mockito.when(random.nextInt()).thenReturn(2));

        /** VERIFY: if exact number of invocations, default 1 time */
        Mockito.verify(random).nextInt();
        // Mockito.verify(random, Mockito.times(2)).nextInt();
    }

}

/**
 * 要点总结:
 * 1. 存在两种声明mock方法, 方法内直接Mockito.mock()或者注解引入, 后者必须MockitoAnnotations.openMocks(this);
 * 2. mock对象方法返回默认值, 除非进行打桩stub操作;
 * 3. verify方法判定对应方法被调用几次
 * */