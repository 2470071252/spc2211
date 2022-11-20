package cn.tedu.spring;

import cn.tedu.bean.ExampleBean;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class ComponentScanTest {
    Logger logger = LoggerFactory.getLogger(ComponentScanTest.class);

    @Autowired
    ApplicationContext context;

    @Test
    void test(){
        ExampleBean bean =  context.getBean(ExampleBean.class);
        logger.debug("{}", bean);
    }
}
