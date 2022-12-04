package cn.tedu.spring.controller;


import cn.tedu.spring.entity.User;
import cn.tedu.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.PostConstruct;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @WebMvcTest 可以对 Web 层（控制器层）进程分片测试
 * 只测试控制器组件，其他组件一概不测试
 *  @WebMvcTest(被测试的组件)，Spring Boot 只创建UserController
 *  的Java bean，其他组件不创建
 *  UserController 依赖的组件，需要使用@MockBean创建模拟对象，
 *  Spring 会自动的将模拟对象，注入给 只创建UserController
 */
@WebMvcTest(UserController.class)
public class WebMvcTestsDemo {
    Logger logger = LoggerFactory.getLogger(WebMvcTestsDemo.class);

    /**
     * 利用@MockBean创建被UserController依赖的对象userService
     * @WebMvcTest 会自动的将userService注入给UserController
     */
    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    /**
     * 训练userService的功能，为了测试控制器的功能
     */
    @PostConstruct
    void init(){
        //训练login方法，此方法是被 UserController login 调用的方法
        Mockito.when(userService.login("John", "1234"))
                .thenReturn(new User(1, "John", "1234", "ADMIN"));
        Mockito.when(userService.getById(2))
                .thenReturn((new User(2, "Andy", "12", "ADMIN")));
        logger.debug("完成训练！");
    }

    @Test
    void login() throws Exception{
        //URL 中{0}的参数占位符
        String url = "/users/login?username={0}&pwd={1}";
        mockMvc.perform(get(url,"John", "1234"))  //请求时候，进行参数替换
                .andExpect(status().isOk())
                .andExpect(content().string("登录成功！"));

        logger.debug("测试完成");
    }
    @Test
    void getUser() throws Exception{
        //URL 中{0}的参数占位符
        String url = "/users/{0}";
        mockMvc.perform(get(url, 2)) //请求时候，进行参数替换
                .andExpect(status().isOk())//检查返回的状态码
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //检查contentType
                .andExpect(jsonPath("username").value("Andy"))//检查返回结果中 json 属性的值
                .andExpect(jsonPath("password").value("12"))
                .andExpect(jsonPath("roles").value("ADMIN"));
        logger.debug("测试完成");
    }

}
