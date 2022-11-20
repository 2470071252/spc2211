package cn.tedu.spring.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {
    @Override
    public String toString() {
        return "singletonBean";
    }
}
