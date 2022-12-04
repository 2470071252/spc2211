package cn.tedu.spring.boot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 在web测试期间使用随机端口
 * RANDOM_PORT 可以避免与正在运行的 8080端口冲突
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Tests {
    Logger logger = LoggerFactory.getLogger(Tests.class);

    @Test
    void test(){
        logger.debug("Test");
    }
}
