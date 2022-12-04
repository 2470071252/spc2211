package cn.tedu.spring.junit;

import cn.tedu.spring.dao.UserDao;
import cn.tedu.spring.entity.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 测试一下 Mockito 框架的功能
 */
public class MockTests {
    Logger logger = LoggerFactory.getLogger(MockTests.class);
    UserDao userDao;
    @Test
    void test(){
        /*
         * 利用Mockito框架创建UserDao接口的实例，Mockito创建的是动态代理对象
         */
        userDao = Mockito.mock(UserDao.class);
        logger.debug("UserDao: {}",userDao.getClass());
        /*
         * 测试没有训练之前对象的行为
         */
        User user = userDao.findUserByName("Tom");
        logger.debug("没有训练前的 findUserByName(\"Tom\") 返回 {}", user);
        /*
         * 训练对象findUserByName的行为
         * 当使用 “Tom”作为参数，则返回 new User(1, "Tom", "12345", "ADMIN")
         */
        Mockito.when(userDao.findUserByName("Tom"))
                .thenReturn(new User(1, "Tom", "12345", "ADMIN"));
        user = userDao.findUserByName("Tom");
        logger.debug("训练后的 findUserByName(\"Tom\") 返回 {}", user);
    }
}
