package cn.tedu.spring.bean;

import org.springframework.stereotype.Component;

/*
 * 隐式创建JavaBean
 */
@Component
public class DemoBean {
    @Override
    public String toString() {
        return "DemoBean";
    }
}
