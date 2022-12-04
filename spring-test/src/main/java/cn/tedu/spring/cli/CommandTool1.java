package cn.tedu.spring.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * 如果组件实现了 CommandLineRunner 接口，则这个组件会在Spring启动后
 * 自动执行 其run方法，args 是命令行参数，默认是空数组
 * args 是原始参数，需要自己解析语法
 * 启动SpringBoot 程序的命令：java -jar xxxx.jar 命令行参数
 *   例子：
 *     java -jar xxxx.jar --user=Tom --host=local
 *
 */
@Component
public class CommandTool1 implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(CommandTool1.class);
    @Override
    public void run(String... args) throws Exception {
        logger.debug("Spring 启动后执行的程序");
        //args = {"--user=Tom", "--host=local"}
        for (String arg:args){
            logger.debug("{}", arg);
        }
    }
}
