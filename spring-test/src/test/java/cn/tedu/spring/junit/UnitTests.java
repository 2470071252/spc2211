package cn.tedu.spring.junit;

import cn.tedu.spring.dao.UserDao;
import cn.tedu.spring.entity.User;
import cn.tedu.spring.exception.IllegalParameterException;
import cn.tedu.spring.exception.PasswordErrorException;
import cn.tedu.spring.exception.UserNotFoundException;
import cn.tedu.spring.service.UserService;
import cn.tedu.spring.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 脱离数据库，对业务层进程测试
 */
public class UnitTests {
    Logger logger = LoggerFactory.getLogger(UnitTests.class);
    UserService userService;
    UserDao userDao;
    /**
     * 在执行测试方法之前，对userService进程初始化
     */
    @BeforeEach
    void init(){
        logger.debug("创建userDao模拟对象，并且训练行为");
        //创建userDao模拟对象，并且训练行为
        userDao = mock(UserDao.class);
        when(userDao.findUserByName("Tom"))
                .thenReturn(new User(1, "Tom", "123", "ADMIN"));
        //使userService依赖模拟的userDao对象，不依赖数据库
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        this.userService = userService;
    }
    @Test
    void login(){
        User user = userService.login("Tom", "123");
        logger.debug("登录结果{}", user);
        //使用断言检查登录结果
        //           期望值        , 实际值
        assertEquals("Tom", user.getUsername());
        logger.debug("检查完 用户名");
        assertEquals("123", user.getPassword());
        logger.debug("检查完 密码");
        //利用断言检查异常情况
        assertThrows(UserNotFoundException.class, ()->{
            userService.login("Jerry", "123");
        });
        logger.debug("检查完 用户不存在的异常");
        assertThrows(PasswordErrorException.class, ()->{
           userService.login("Tom", "aaaa");
        });
        logger.debug("检查完 密码错误异常");
        assertThrows(IllegalParameterException.class, ()->{
            userService.login("","");
        });
        assertThrows(IllegalParameterException.class, ()->{
            userService.login("Tom","");
        });
        logger.debug("检查完 空参数异常");
    }
}








