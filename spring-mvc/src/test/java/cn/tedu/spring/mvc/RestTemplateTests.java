package cn.tedu.spring.mvc;

import cn.tedu.spring.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
public class RestTemplateTests {

    Logger logger = LoggerFactory.getLogger(RestTemplateTests.class);

    @Test
    void getForObject(){
        /*
         * 测试 使用 RestTemplate 作为客户端，访问Rest服务器
         */
        RestTemplate restTemplate = new RestTemplate();
        //  如果使用URL参数，需要设置参数占位符{0} {1} {2} ...
        String url = "http://localhost:8080/users/{0}";
        //  调用时候，进行参数替换， 按照顺序进行替换， User.class表示返回类型
        User user = restTemplate.getForObject(url, User.class, 4);
        logger.debug("返回： {}", user);
    }
}
