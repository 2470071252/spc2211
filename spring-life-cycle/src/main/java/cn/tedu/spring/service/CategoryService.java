package cn.tedu.spring.service;

import cn.tedu.spring.entity.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CategoryService {
    Logger logger = LoggerFactory.getLogger(CategoryService.class);
    /**
     * 分类缓存
     */
    private CopyOnWriteArrayList<Category> categoryList;

    public void init() {
        categoryList = new CopyOnWriteArrayList<>();
        categoryList.add(new Category("1","家电"));
        categoryList.add(new Category("2","食品"));
        categoryList.add(new Category("2","服装"));
        logger.debug("初始化分类{}", categoryList);
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void destroy(){
        logger.debug("销毁 {}", categoryList);
        categoryList.clear();
    }
}
