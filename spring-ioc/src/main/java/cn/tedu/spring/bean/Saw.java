package cn.tedu.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class Saw implements Tool {
    @Override
    public String toString() {
        return "寒冰锯";
    }
}
