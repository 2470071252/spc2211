package cn.tedu.spring;

import cn.tedu.spring.mapper.DemoMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTests {
    Logger logger = LoggerFactory.getLogger(MapperTests.class);

    @Autowired
    DemoMapper demoMapper;

    @Test
    void test(){
        logger.debug("{}", demoMapper.hello());
        logger.debug("{}", demoMapper.getClass().getName());
    }
}
