package cn.tedu.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Worker {
    Logger logger = LoggerFactory.getLogger(Worker.class);
    private String name = "光头强";
//
//    @Autowired
//    public Worker(@Qualifier("saw") Tool tool){
//        this.tool = tool;
//    }

    //@Autowired
    //设置beanid, 按照名字匹配安装
    // @Resource(name = "saw")
    private Tool tool;

    //@Autowired
    @Resource(name = "saw")
    public void demo(Tool tool) {
        this.tool = tool;
    }

    public Worker() {
    }

    public void work(){
        logger.debug("{}使用{}砍树", name, tool);
    }
}
