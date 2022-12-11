package cn.tedu.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Aspect 来自 AspectJ, Spring 支持这个注解的功能
 * 用于定义切面儿功能组件， 必须和@Component或者@Bean联合使用
 */
@Component
@Aspect
public class DemoAspect {
    Logger logger = LoggerFactory.getLogger(DemoAspect.class);

    /**
     *  before 方法在 userServiceImpl bean的全部方法之前（@Before）执行
     * @param joinPoint 连接点：正在执行的当前方法
     */
    @Before("bean(userServiceImpl)")
    public void before(JoinPoint joinPoint){
        // Signature 签名，这里是方法签名=方法名+参数类型列表
        Signature method = joinPoint.getSignature();
        logger.debug("再{}时间，执行{}方法之前", LocalDateTime.now(), method);
    }

    /**
     * after 方法在 userServiceImpl bean的全部方法之前（@After）执行
     * @param joinPoint
     */
    @After("bean(userServiceImpl)")
    public void after(JoinPoint joinPoint){
        // Signature 签名，这里是方法签名=方法名+参数类型列表
        Signature method = joinPoint.getSignature();
        logger.debug("再{}时间，执行{}方法之后", LocalDateTime.now(), method);
    }

}
