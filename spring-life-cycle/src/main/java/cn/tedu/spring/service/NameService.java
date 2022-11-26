package cn.tedu.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Scope("prototype")
public class NameService {
    Logger logger = LoggerFactory.getLogger(NameService.class);
    /**
     * 本地缓存，缓存了名字信息
     */
    private CopyOnWriteArrayList<String> names = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init(){
        names.add("Tom");
        names.add("Jerry");
        names.add("Andy");
        logger.debug("初始化 {}", names);
    }

    /**
     * Spring不会调用“Prototype”组件的销毁方法
     */
    @PreDestroy
    public void destroy(){
        logger.debug("销毁 {}", names);
        names.clear();
    }
}
