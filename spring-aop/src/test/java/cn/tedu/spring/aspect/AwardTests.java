package cn.tedu.spring.aspect;

import cn.tedu.spring.entity.Award;
import cn.tedu.spring.entity.User;
import cn.tedu.spring.service.AwardService;
import cn.tedu.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AwardTests {
    Logger logger = LoggerFactory.getLogger(AwardTests.class);

    @Autowired
    AwardService awardService;

    @Autowired
    UserService userService;

    @Test
    void test(){
        User user = userService.getById(1);
        awardService.grantAward(user, "奖励", 20);
        logger.debug("grantAward");
    }
}
