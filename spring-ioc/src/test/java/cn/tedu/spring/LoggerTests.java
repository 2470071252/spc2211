package cn.tedu.spring;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggerTests {
    /**
     * 创建日志对象
     */
    private final static Logger logger = LoggerFactory.getLogger(LoggerTests.class);

    @Test
    void demo(){
        //System.out.println("Hello World!");
        logger.trace("Hello trace");
        logger.debug("Hello debug, 执行了Login方法");
        logger.info("Hello World, 用户提交参数:");
        logger.warn("Hello warn, 用户名不存在");
        logger.error("Hello error, 数据库失败");
    }

    @Test
    void testParam(){
        long t1 = System.nanoTime();
        System.out.println("Hello Error");
        long t2 = System.nanoTime();
        logger.debug("销耗时间{}{}", t2-t1,"纳秒");
        System.out.println(t2-t1);
        t1 = System.nanoTime();
        logger.error("Hello Error");
        t2 = System.nanoTime();
        //输出有参数的日志
        //使用 {} 作为占位符, 后续使用参数替换
        logger.debug("销耗时间{}{}", t2-t1,"纳秒");
        System.out.println(t2-t1);
    }
}
