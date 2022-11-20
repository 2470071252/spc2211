package cn.tedu.spring;

import cn.tedu.bean.Single;
import cn.tedu.spring.bean.PrototypeBean;
import cn.tedu.spring.bean.SingletonBean;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ScopeTests {
    Logger logger = LoggerFactory.getLogger(ScopeTests.class);

    @Resource
    //@Autowired
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

    @Test
    void single(){
        Single single = context.getBean(Single.class);
        logger.debug("{}", single);
    }

    @Test
    void scopeTests(){
        List<String> list1 = context.getBean("provinceList", List.class);
        List<String> list2 = context.getBean("provinceList", List.class);
        logger.debug("单例 {}", list1==list2);
        List<String> list3 = context.getBean("cityList", List.class);
        List<String> list4 = context.getBean("cityList", List.class);
        logger.debug("原形 {}", list3==list4);

    }
}
