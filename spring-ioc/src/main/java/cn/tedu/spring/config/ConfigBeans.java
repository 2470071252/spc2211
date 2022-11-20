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
     */
    @Bean
    public List<String> names(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Tom");
        names.add("Jerry");
        return names;
    }
}
