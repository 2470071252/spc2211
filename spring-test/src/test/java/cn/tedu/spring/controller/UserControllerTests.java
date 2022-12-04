package cn.tedu.spring.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;
import static  org.junit.jupiter.api.Assertions.*;

/**
 * 对UserController进程测试
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UserControllerTests {
    Logger logger = LoggerFactory.getLogger(UserControllerTests.class);

    /*
     * @SpringBootTest 注解会自动创建 TestRestTemplate 对象
     * 注入 TestRestTemplate 对象，用于作为客户端测试控制器
     * TestRestTemplate 提供了自动通过随机端口请求控制器方法
     */
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void login(){
        //get请求参数，使用{0} {1} 设置占位符，调用时候进行参数替换
        String url = "/users/login?username={0}&pwd={1}";
        //getForObject(URL, 返回值类型, 参数1, 参数2  ... )
        String response = restTemplate.getForObject(url, String.class,
                "jerry", "1234" );
        logger.debug("结果 {}", response);
        assertEquals("登录成功！", response);
    }
}
