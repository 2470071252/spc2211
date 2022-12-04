package cn.tedu.spring.cli;

import cn.tedu.spring.entity.User;
import cn.tedu.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 实现 ApplicationRunner 接口的组件也在 Spring 启动以后自动执行
 * 与CommandLineRunner的区别是 ApplicationRunner 解析了命令行参数
 *
 */
@Component
public class ApplicationTool implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(ApplicationTool.class);

    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // ApplicationArguments 存储了 解析号的 命令行参数 key：value
        logger.debug("启动后立即执行");
        args.getOptionNames().forEach(
                name->{logger.debug("{} {}", name, args.getOptionValues(name));});
        User user = userService.getById(1);
        logger.debug("{}", user);
    }
}
