package cn.tedu.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Worker {
    Logger logger = LoggerFactory.getLogger(Worker.class);
    private String name = "光头强";

    @Autowired
    private Tool tool;

    public Worker() {
        logger.debug("创建工人");
    }

    public void work(){
        logger.debug("{}使用{}砍树", name, tool);
    }
}
