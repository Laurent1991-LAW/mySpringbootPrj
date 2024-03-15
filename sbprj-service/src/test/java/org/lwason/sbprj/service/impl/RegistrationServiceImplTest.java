package org.lwason.sbprj.service.impl;

import com.lwason.sbprj.common.entity.User;
import com.lwason.sbprj.common.exception.DAOException;
import com.lwason.sbprj.common.exception.ValidationException;
import com.lwason.sbprj.common.util.FindUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lwason.sbprj.dao.SalesDao;
import org.lwason.sbprj.dao.UserDao;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.sql.SQLException;

class RegistrationServiceImplTest {

    /**  @InjectMocks: mocks below will be injected into Spy as class fields */
    @InjectMocks
    /**Unlike Mock, Spy means real object and real method calls*/
    @Spy
    private RegistrationServiceImpl registrationService;
    @Mock
    private UserDao userDao;
    @Mock
    private SalesDao salesDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void register() throws Exception {
        String name = null;
        String phone = "15071271412";
        try {
            registrationService.register(name, phone);
            Assertions.fail("Got here ? NO WAY");
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof ValidationException);
        }

        name = "some weird name";
        phone = null;
        try {
            registrationService.register(name, phone);
            Assertions.fail("Got here ? NO WAY");
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof ValidationException);
        }

        phone = "15071271412";

        /**
         * staticMock is stored in ThreadLocal which needs to be closed,
         * or static mock in other tests might not pass
         * ''static mocking is already registered in the current thread'' */
        try (MockedStatic<FindUtils> staticService = Mockito.mockStatic(FindUtils.class)) {
            staticService.when(() -> FindUtils.getAreaCode("15071271412")).thenReturn("a");
            staticService.when(() -> FindUtils.getOperatorCode("15071271412")).thenReturn("b");
        }

        /** successful SQL executed scenario */
        Mockito.when(salesDao.findRep("a","b")).thenCallRealMethod();
        Mockito.when(userDao.save(name, phone, "Echo")).thenCallRealMethod();
        User user = registrationService.register(name, phone);
        Assertions.assertEquals("Echo", user.getRepId());

        /** SQL executed with exception scenario */
        Mockito.when(userDao.save(name, phone, "Echo")).thenThrow(new SQLException());
        try {
            registrationService.register(name, phone);
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof DAOException);
        }
    }

    @Test
    void staticMockTest01() {
        /** Fail if MockedStatic hasn't been closed in above test */
        // MockedStatic<FindUtils> staticService = Mockito.mockStatic(FindUtils.class);
    }

}

/**
 * 要点整理:
 * 1. InjectMocks可以将其他@Mock注解fields注入到spy内部;
 * 2. MockedStatic<T>需要关闭, 否则影响后继测试中再次MockedStatic<T>, 可用BeforeEach和AfterEach进行统一开闭;
 * 3. doThrow(), doAnswer(), doNothing(), doReturn() 和 doCallRealMethod() 一般应用于返回void的方法, 因为编译器不喜欢将无返回值的方法体放入括号中
 *              doThrow(new RuntimeException()).when(mockedList).clear();
 *              when(mockedList.get(anyInt())).thenReturn("element");
 *     但为什么会有doReturn(), 因为它也适用于多次被stub的方法以在测试中间改变其action 或 在spy中使用, 如
 *              List list = new LinkedList();
 *              List spy = spy(list);
 *               //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
 *               when(spy.get(0)).thenReturn("foo");
 *              //You have to use doReturn() for stubbing
 *              doReturn("foo").when(spy).get(0);
 */