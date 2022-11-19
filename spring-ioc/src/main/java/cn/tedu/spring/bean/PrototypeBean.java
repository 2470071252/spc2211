package cn.tedu.spring.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //原型，每次使用都会创建一个新对象
public class PrototypeBean {
    @Override
    public String toString() {
        return "prototypeBean";
    }
}
