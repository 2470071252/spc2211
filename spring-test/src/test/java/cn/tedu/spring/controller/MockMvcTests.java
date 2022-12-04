package cn.tedu.spring.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

// 静态导入，测试工具MockMvcRequestBuilders 用于发生请求
// MockMvcResultMatchers 用于检查控制器反馈结果
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 使用MockMvc进程控制器测试
 * 不需要启动服务器的快速测试
 * @AutoConfigureMockMvc 注解会自动创建 MockMvc 对象，用于对控制器测试
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MockMvcTests {

    Logger logger = LoggerFactory.getLogger(MockMvcTests.class);

    @Autowired
    MockMvc mockMvc;

    @Test
    void hello() throws Exception{
        String url = "/demo/hello";
        //perform(get(url)) 发起get请求
        // andExpect() 期待结果  status().isOk() 状态码是200 OK
        mockMvc.perform(get(url)).andExpect(status().isOk());
        logger.debug("Mock MVC 测试通过");
    }

}
