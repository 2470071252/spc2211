package cn.tedu.spring.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "cn.tedu.spring.mapper")
@Configuration
public class MyBatisConfig {
}
