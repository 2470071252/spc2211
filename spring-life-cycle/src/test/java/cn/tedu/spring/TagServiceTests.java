package cn.tedu.spring;

import cn.tedu.spring.service.TagService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TagServiceTests {

    Logger logger = LoggerFactory.getLogger(TagServiceTests.class);

    @Autowired
    TagService tagService;

    @Test
    void tests(){
        List<String> tags = tagService.getTags();
        tags.forEach(tag->logger.debug("{}", tag));
    }
}
