package cn.tedu.spring.config;

import cn.tedu.bean.Single;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration  //配置
//@Component      //组件
//@Service          //服务
public class SingleConfig {
    /**
     * 将 遗留系统(单例模式) 整合到Spring中
     */
    @Bean
    public Single single(){
        return Single.getInstance();
    }
}
