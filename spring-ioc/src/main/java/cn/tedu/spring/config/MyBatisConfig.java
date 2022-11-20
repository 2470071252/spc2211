package cn.tedu.spring.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "cn.tedu.spring.mapper")
public class MyBatisConfig {
}
