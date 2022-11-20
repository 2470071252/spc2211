package cn.tedu.spring;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggerTests {
    /**
     * 创建日志对象
     */
    Logger logger = LoggerFactory.getLogger(LoggerTests.class);

    @Test
    void demo(){
        logger.info("Hello World");
    }
}
