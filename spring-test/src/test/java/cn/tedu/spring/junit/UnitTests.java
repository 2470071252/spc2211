package cn.tedu.spring.junit;

import cn.tedu.spring.dao.UserDao;
import cn.tedu.spring.entity.User;
import cn.tedu.spring.service.UserService;
import cn.tedu.spring.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        userDao = Mockito.mock(UserDao.class);
        Mockito.when(userDao.findUserByName("Tom"))
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
    }
}
