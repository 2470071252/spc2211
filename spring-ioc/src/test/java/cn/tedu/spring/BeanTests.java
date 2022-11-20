package cn.tedu.spring;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BeanTests {

    Logger logger = LoggerFactory.getLogger(BeanTests.class);

    @Autowired
    List<String> names;

    @Test
    void names(){
        logger.debug("names: {}", names);
    }
}
