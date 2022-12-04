package cn.tedu.spring.controller;

import cn.tedu.spring.entity.User;
import cn.tedu.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MockBeanTests {
    Logger logger = LoggerFactory.getLogger(MockBeanTests.class);
    /**
     * @MockBean 是Spring提供的注解，底层就是mockito 框架
     * Spring会自动调用 mockito 框架，创建 接口的实例
     * 如下代码 userService 就是创建的模拟对象
     */
    @MockBean
    UserService userService;

    @Test
    void test(){
        logger.debug("MockBean {}", userService.getClass());
        /*
         * 对动态创建的模拟对象进行功能训练
         */
        Mockito.when(userService.getById(1))
                .thenReturn(new User(1, "Tom", "123", "ADMIN"));
        /*
         * 测试训练结果
         */
        User user = userService.getById(1);
        logger.debug("User {}", user);
        assertEquals("Tom", user.getUsername());
        assertEquals("123", user.getPassword());
    }
}
