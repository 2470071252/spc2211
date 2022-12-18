package cn.tedu.spring.mvc;

import cn.tedu.spring.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@SpringBootTest
public class RestTemplateTests {

    Logger logger = LoggerFactory.getLogger(RestTemplateTests.class);

    RestTemplate restTemplate = new RestTemplate();
    @Test
    void getForObject(){
        /*
         * 测试 使用 RestTemplate 作为客户端，访问Rest服务器
         */
        //  如果使用URL参数，需要设置参数占位符{0} {1} {2} ...
        String url = "http://localhost:8080/users/{0}";
        //  调用时候，进行参数替换， 按照顺序进行替换， User.class表示返回类型
        User user = restTemplate.getForObject(url, User.class, 4);
        logger.debug("返回： {}", user);
    }

    @Test
    void users(){
        /*
         * 获取多个用户信息
         */
        String url = "http://localhost:8080/users";
        User[] users = restTemplate.getForObject(url, User[].class);
        for(User user: users){
            logger.debug("{}", user);
        }
    }

    @Test
    void post(){
        /*
         * post 向服务器添加数据
         */
        String url = "http://localhost:8080/users";
        User user = new User(null, "Mac", "abc", "ADMIN");
        User u = restTemplate.postForObject(url, user, User.class);
        logger.debug("{}", u);
    }

    @Test
    void put(){
        /*
         * put 修改服务器上的用户信息
         */
        String url = "http://localhost:8080/users";
        User user = new User(4, "tony", "abc123", "ADMIN");
        restTemplate.put(url, user);
    }

    @Test
    void delete(){
        /*
         * 删除 用户信息
         */
        String url = "http://localhost:8080/users/{0}";
        restTemplate.delete(url, 7);
    }

}
