package cn.tedu.spring;

import cn.tedu.spring.bean.Worker;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WorkerTests {
    Logger logger = LoggerFactory.getLogger(WorkerTests.class);

    @Autowired
    Worker worker;

    @Test
    void tests(){
        logger.debug("{}", worker);

    }

    @Test
    void work(){
        worker.work();
    }
}
