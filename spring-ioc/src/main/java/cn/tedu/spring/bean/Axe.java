package cn.tedu.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class Axe implements Tool {
    @Override
    public String toString() {
        return "开天斧";
    }
}
