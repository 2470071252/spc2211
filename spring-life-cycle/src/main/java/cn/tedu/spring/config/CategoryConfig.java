package cn.tedu.spring.config;

import cn.tedu.spring.service.CategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {
    /**
     * @Bean 显示生命Bean使用设置，初始化和销毁方法
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public CategoryService categoryService(){
        return new CategoryService();
    }
}
