package cn.tedu.spring.proxy;

import cn.tedu.spring.controller.UserController;
import cn.tedu.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringProxyTests {
    Logger logger = LoggerFactory.getLogger(SpringProxyTests.class);

    @Autowired
    UserService userService;

    @Autowired
    UserController userController;

    @Test
    void userService(){
        /**
         * 测试 代理对象的类型
         */
        logger.debug("代理对象类型 {}", userService.getClass().getName());
        logger.debug("代理对象类型 {}", userController.getClass().getName());
    }
}
