package cn.tedu.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@Component
/**
 * 如果有工人类型Bean就可以创建 斧子Bean
 * 如果缺少Tool类型的Bean就创建(忽略掉当前的斧子) 斧子Bean
 */
@ConditionalOnMissingBean(name = "saw")
public class Axe implements Tool {
    Logger logger = LoggerFactory.getLogger(Axe.class);

    public Axe(){
        logger.debug("创建斧子");
    }

    @Override
    public String toString() {
        return "开天斧";
    }
}
