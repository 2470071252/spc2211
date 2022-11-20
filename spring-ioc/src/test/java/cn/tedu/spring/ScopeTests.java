package cn.tedu.spring;

import cn.tedu.spring.bean.PrototypeBean;
import cn.tedu.spring.bean.SingletonBean;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class ScopeTests {
    Logger logger = LoggerFactory.getLogger(ScopeTests.class);

    @Autowired
    ApplicationContext context;

    @Test
    void test(){
        SingletonBean bean1 = context.getBean(SingletonBean.class);
        SingletonBean bean2 = context.getBean(SingletonBean.class);
        logger.debug("单例 {}", bean1 == bean2);
        PrototypeBean bean3 = context.getBean(PrototypeBean.class);
        PrototypeBean bean4 = context.getBean(PrototypeBean.class);
        logger.debug("原形 {}", bean3 == bean4);
    }
}
