package cn.tedu.spring;

import cn.tedu.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyServiceTests {
    Logger logger = LoggerFactory.getLogger(MyServiceTests.class);

    @Autowired
    UserService userService;

    @Test
    void test(){
        logger.debug("{}", userService);
    }
}
