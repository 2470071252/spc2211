package cn.tedu.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ScopeConfig {
    @Bean
    public List<String> provinceList(){
        List<String> list = new ArrayList<>();
        list.add("辽宁");
        list.add("吉林");
        return list;
    }
    @Bean
    @Scope("prototype")
    public List<String> cityList(){
        List<String> list = new ArrayList<>();
        list.add("上海");
        list.add("广州");
        return list;
    }
}
