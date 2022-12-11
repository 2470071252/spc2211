package cn.tedu.spring.aspect;

import cn.tedu.spring.entity.User;
import cn.tedu.spring.service.UserService;
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
         * 调用方法时候， AOP会在方法之前执行
         */
        User user = userService.getById(1);
        logger.debug("getById {}", user);
        user = userService.getByUsername("tom");
        logger.debug("getByUsername {}", user);
    }
}