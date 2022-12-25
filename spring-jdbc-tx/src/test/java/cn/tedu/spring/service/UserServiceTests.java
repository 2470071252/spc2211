package cn.tedu.spring.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {
    Logger logger = LoggerFactory.getLogger(UserServiceTests.class);

    @Autowired
    UserService userService;

    @Test
    void userService(){
        logger.debug(" Class {}", userService.getClass().getName());
    }
}
