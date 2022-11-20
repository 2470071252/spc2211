package cn.tedu.spring;

import cn.tedu.spring.bean.DemoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringIocApplication {

    static Logger logger = LoggerFactory.getLogger(SpringIocApplication.class);

    public static void main(String[] args) {
        //run 返回当前Spring 的容器对象
        ApplicationContext context =
            SpringApplication.run(SpringIocApplication.class, args);
        //获取类型唯一的 Java Bean 对象
        DemoBean demoBean = context.getBean(DemoBean.class);
        logger.debug("{}", demoBean);
        //按照ID获取Bean
        List<String> list = context.getBean("names", List.class);
        logger.debug("list {}", list);
    }

}
