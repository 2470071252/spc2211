package cn.tedu.spring.boot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
/**
 * 在web测试期间使用随机端口
 * RANDOM_PORT 可以避免与正在运行的 8080端口冲突
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Tests {
    Logger logger = LoggerFactory.getLogger(Tests.class);

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void test(){
        logger.debug("Test");
        logger.debug("TestRestTemplate {}", restTemplate);
    }

    /*
     * 使用 restTemplate 对Web控制器进行自动化测试
     */
    @Test
    void demo(){
        //是相对路径，不指定ip，不指定端口好
        String url = "/demo/hello";
        //getForObject(URL, 返回值类型)
        String message = restTemplate.getForObject(url, String.class);
        logger.debug("返回信息 {}", message);
        //通过断言自动判断测试返回结果
        assertEquals("Hello World!", message);
    }

}
