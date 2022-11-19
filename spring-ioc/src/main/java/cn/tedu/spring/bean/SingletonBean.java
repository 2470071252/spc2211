package cn.tedu.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    @Override
    public String toString() {
        return "singletonBean";
    }
}
