package cn.tedu.spring.config;

import cn.tedu.bean.Single;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SingleConfig {
    /**
     * 将 遗留系统(单例模式) 整合到Spring中
     */
    @Bean
    public Single single(){
        return Single.getInstance();
    }
}
