package cn.tedu.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 标签服务
 * concurrent 并发
 */
@Component
public class TagService {
    Logger logger = LoggerFactory.getLogger(TagService.class);
    /**
     * 本地缓存，缓存了标签信息
     */
    private final CopyOnWriteArrayList<String> tags = new CopyOnWriteArrayList<>();

    @PostConstruct  //创建对象以后调用
    public void initTags() {
        tags.add("应季");
        tags.add("爆款");
        tags.add("进口");
        tags.add("生鲜");
        tags.add("健身");
        logger.debug("初始化标签{}", tags);
    }

    public List<String> getTags() {
        return tags;
    }

    @PreDestroy //销毁对象之前调用
    public void destroy() {
        logger.debug("清空标签{}", tags);
        tags.clear();
    }
}
