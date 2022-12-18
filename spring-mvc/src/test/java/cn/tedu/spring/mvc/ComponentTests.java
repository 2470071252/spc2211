package cn.tedu.spring.mvc;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
public class ComponentTests {
    Logger logger = LoggerFactory.getLogger(ComponentTests.class);

    @Autowired
    ApplicationContext context;

    @Test
    void test(){
        /*
         * Spring Boot 自动配置的 Spring MVC 组件：
         *  前端控制器（只有一个！）
         *  映射处理器 多个
         *  视图处理器 多个
         *  消息转换器 多个
         */
        DispatcherServlet servlet = context.getBean(DispatcherServlet.class);
        logger.debug("前端控制器 {}", servlet);
        String[] handlerMappings = context.getBeanNamesForType(HandlerMapping.class);
        logger.debug("映射处理器：{}", Arrays.toString(handlerMappings));
        String[] viewResolvers = context.getBeanNamesForType(ViewResolver.class);
        logger.debug("视图处理器：{}", Arrays.toString(viewResolvers));
        String[] messageConvertors = context.getBeanNamesForType(HttpMessageConverter.class);
        logger.debug("消息转换器：{}", Arrays.toString(messageConvertors));
    }
}
