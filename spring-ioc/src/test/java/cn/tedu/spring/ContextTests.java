package cn.tedu.spring;

import cn.tedu.spring.bean.DemoBean;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
public class ContextTests {
    Logger logger = LoggerFactory.getLogger(ContextTests.class);

    /**
     * 利于@Autowired方式可以获得当前的 ApplicationContext
     */
    @Autowired
    ApplicationContext context;
    @Test
    void tests(){
        DemoBean demoBean = context.getBean(DemoBean.class);
        List<String> list = context.getBean("names", List.class);
        logger.debug("{} {}", demoBean, list);
    }
    @Test
    void beanNames(){
        /*
         * 获取Bean Names, 包含我们定义的Bean和Spring的Bean
         */
        String[] names = context.getBeanDefinitionNames();
        for (String name: names){
            logger.debug("{}", name);
        }
    }
}
