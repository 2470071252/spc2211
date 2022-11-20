package cn.tedu.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置类的位置: 在Spring Boot启动类的包和子包中
 * 这个位置会被自动扫描加载
 */
@Configuration
public class ConfigBeans {
    /**
     * 使用@Bean显示创建Java对象
     * @Bean 创建JavaBean 时候BeanID就是方法名称
     * Bean ID: names
     */
    @Bean
    public List<String> names(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Tom");
        names.add("Jerry");
        return names;
    }

    /**
     * Bean ID: mobilePhone
     */
    @Bean
    public List<String> mobilePhone(){
        ArrayList<String> list = new ArrayList<>();
        list.add("119");
        list.add("110");
        return list;
    }

    /**
     * Bean ID: cities
     */
    @Bean
    public List<String> cities(){
        ArrayList<String> list = new ArrayList<>();
        list.add("北京");
        list.add("上海");
        return list;
    }
}
