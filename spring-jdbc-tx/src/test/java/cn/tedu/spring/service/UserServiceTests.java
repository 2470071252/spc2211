package cn.tedu.spring.service;

import cn.tedu.spring.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootTest
public class UserServiceTests {
    Logger logger = LoggerFactory.getLogger(UserServiceTests.class);

    @Autowired
    UserService userService;

    @Test
    void userService(){
        //在业务层中添加 @Transactional 后userService
        //的类型，就会出现 动态代理类。这个动态代理类提供
        //事务管理功能。
        logger.debug(" Class {}", userService.getClass().getName());
    }

    @Autowired
    PlatformTransactionManager transactionManager;

    @Test
    void txMgr(){
        // transactionManager 事务管理器，@Transactional 底层
        // 就是利用 transactionManager 实现功能，transactionManager
        // 可以有不同平台的实现，支持 Hibernate Spring-JDBC MyBatis
        // transactionManager 自动支持，统一管理，简单配置后，就能够
        // 统一处理事务。
        logger.debug("{}", transactionManager.getClass().getName());
    }

    @Test
    void regist(){
        /*
         * 测试：注册送积分，设置了事务
         */
         User user = userService.regist("Mac", "123");
         logger.debug(" {}", user);
    }
}
