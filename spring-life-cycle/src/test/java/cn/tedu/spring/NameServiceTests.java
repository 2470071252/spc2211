package cn.tedu.spring;

import cn.tedu.spring.service.NameService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NameServiceTests {

    Logger logger = LoggerFactory.getLogger(NameServiceTests.class);

    @Autowired
    NameService nameService;

    @Test
    void tests(){
        List<String> names = nameService.getNames();
        names.forEach(name->logger.debug("{}", name));
    }
}
