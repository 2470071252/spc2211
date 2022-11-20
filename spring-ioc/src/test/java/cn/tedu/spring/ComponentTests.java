package cn.tedu.spring;

import cn.tedu.spring.bean.DemoBean;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ComponentTests {
    Logger logger = LoggerFactory.getLogger(ComponentTests.class);

    @Autowired
    DemoBean demoBean;

    @Test
    void demoBean(){
        logger.debug("Demo {}",  demoBean);
    }
}
