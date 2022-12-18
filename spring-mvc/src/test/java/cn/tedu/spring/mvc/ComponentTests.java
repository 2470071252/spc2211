package cn.tedu.spring.mvc;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootTest
public class ComponentTests {
    Logger logger = LoggerFactory.getLogger(ComponentTests.class);

    @Autowired
    ApplicationContext context;

    @Test
    void test(){
        DispatcherServlet servlet = context.getBean(DispatcherServlet.class);
    }
}
