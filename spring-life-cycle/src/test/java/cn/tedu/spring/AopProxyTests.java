package cn.tedu.spring;

import cn.tedu.spring.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopProxyTests {

    Logger logger = LoggerFactory.getLogger(AopProxyTests.class);

    @Autowired
    CategoryService categoryService;

    @Test
    void test(){
        /*
         * 添加AOP以后，获得categoryService对象的代理对象
         * 这个代理对象 就是 Spring 在初始化对象时候
         * 执行AspectJAwareAdvisorAutoProxyCreator
         * 创建的代理对象
         */
        logger.debug("{}", categoryService.getClass().getName());
    }

}
