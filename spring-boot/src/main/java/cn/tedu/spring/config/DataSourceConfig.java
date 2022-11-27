package cn.tedu.spring.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
//    //获取 application.properties 中的配置信息
//    @Value("${spring.datasource.url}")
//    String url;
//    @Value("${spring.datasource.username}")
//    String username;
//    @Value("${spring.datasource.password}")
//    String password;
//
//    @Bean
//    public DataSource dataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
}
