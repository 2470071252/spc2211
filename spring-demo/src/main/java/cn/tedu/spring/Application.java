package cn.tedu.spring;

import cn.tedu.spring.bean.DemoBean;
import cn.tedu.spring.config.ContextConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfig.class);

        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean);
    }
}
