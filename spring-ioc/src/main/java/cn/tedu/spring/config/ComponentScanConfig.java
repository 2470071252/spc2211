package cn.tedu.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义组件扫描功能
 * 组件扫描范围是包和子包
 * 组件扫描时候尽量使用具体包进行扫描!
 * 可以减少扫描范围, 提升软件启动性能!
 */
@Configuration
@ComponentScan({"cn.tedu.bean","cn.tedu.service"})
//@ComponentScan({"cn.tedu"})
//@ComponentScan("cn")
public class ComponentScanConfig {
}
