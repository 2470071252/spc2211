package cn.tedu.spring.proxy;

import cn.tedu.spring.mapper.DemoMapper;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisTests {

    Logger logger = LoggerFactory.getLogger(MyBatisTests.class);

    @Autowired
    DemoMapper demoMapper;

    @Test
    void test(){
        String str = demoMapper.hello();
        logger.debug("demoMapper的类型 {}", demoMapper.getClass().getName());
        logger.debug("{}", str);
    }

}
