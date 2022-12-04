package cn.tedu.spring.controller;

import cn.tedu.spring.service.UserService;
import com.mysql.cj.log.Log;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
    }

}
