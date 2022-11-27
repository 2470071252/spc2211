package cn.tedu.spring;

import cn.tedu.spring.entity.Category;
import cn.tedu.spring.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryServiceTests {

    Logger logger = LoggerFactory.getLogger(CategoryServiceTests.class);

    @Autowired
    CategoryService categoryService;

    @Test
    void test(){
        List<Category> list = categoryService.getCategoryList();
        list.forEach(category->logger.debug("{}", category));
    }
}
