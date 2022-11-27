package cn.tedu.spring.hook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 在当前虚拟机上挂关闭钩子
 */
@Component
public class HockBean extends Thread {

    Logger logger = LoggerFactory.getLogger(HockBean.class);

    @PostConstruct
    void addHock(){
        Runtime.getRuntime().addShutdownHook(this);
        logger.debug("在当前虚拟机上挂关闭钩子");
    }

    @Override
    public void run() {
        logger.debug("系统关闭！");
    }
}
