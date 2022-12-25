package cn.tedu.spring.dao;

import cn.tedu.spring.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserDaoTests {

    Logger logger = LoggerFactory.getLogger(UserDaoTests.class);

    @Autowired
    UserDao userDao;

    @Test
    void updateUser(){
        logger.debug("UserDao 类型 {}", userDao.getClass().getName());
        User user = new User(4, "Lee", "abcd", "ADMIN");
        int n = userDao.updateUser(user);
        logger.debug("修改了 {} 行", n);
    }

    @Test
    void insertUser(){
        User user = new User(null, "Fan", "123", "ADMIN");
        userDao.addUser(user);
        logger.debug("User {}", user);
        Assertions.assertNotNull(user.getId());
    }

    @Test
    void countUsers(){
        Integer n = userDao.countUsers();
        logger.debug("Users: {}", n);
    }

    @Test
    void findAllUsers(){
        List<Map<String, Object>> list = userDao.findAllUsers();
        list.forEach(map->logger.debug("{}", map));
    }

    @Test
    void findAllUser(){
        List<User> list = userDao.findAllUser();
        list.forEach(user -> logger.debug("User {}", user));
    }
}
