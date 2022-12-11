package cn.tedu.spring.aspect;

import cn.tedu.spring.entity.User;
import cn.tedu.spring.exception.UserNotFoundException;
import cn.tedu.spring.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoAspectTests {

    Logger logger = LoggerFactory.getLogger(DemoAspectTests.class);

    @Autowired
    UserService userService;

    @Test
    void tests(){
        /**
         * 调用userService方法时候， AOP会在userService的方法之前执行
         */
        logger.debug("userService 的类型 {}", userService.getClass().getName());
        //@Before
        User user = userService.getById(1);
        //@After
        logger.debug("getById {}", user);

        //@Before
        user = userService.getByUsername("tom");
        //@After
        logger.debug("getByUsername {}", user);
    }

    @Test
    void login(){
        //测试正常返回
        User user = userService.login("tom", "1234");
        Assertions.assertEquals("tom", user.getUsername());
        logger.debug("登录结果 {}", user);

        Assertions.assertThrows(UserNotFoundException.class, ()->{
            userService.login("Hi","1234");
        });
        logger.debug("已经出现异常");
    }
}
