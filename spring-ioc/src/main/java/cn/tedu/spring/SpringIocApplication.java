package cn.tedu.spring;

import cn.tedu.spring.bean.DemoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
/*
 * @SpringBootApplication 的元注解包含 @Configuration
 * 所以 被标注的启动类 SpringIocApplication 是配置类
 *
 * @SpringBootApplication 包含 @ComponentScan, 所以
 * 启动后自动开启组件扫描功能, 扫描范围: 当前包和子包中
 * - 凡是标注@Component都创建为Java Bean
 * - 凡是标注@Configuration都创建为Java Bean, 并且作为配置类
 *
 */
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
