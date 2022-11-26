package cn.tedu.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component

/**
 * 如果存在 Worker 类型的对象时候，就创建电锯对象
 */
//@ConditionalOnBean(Worker.class)
public class Saw implements Tool {
    Logger logger = LoggerFactory.getLogger(Saw.class);

    public Saw(){
        logger.debug("创建电锯");
    }
    @Override
    public String toString() {
        return "寒冰锯";
    }
}
