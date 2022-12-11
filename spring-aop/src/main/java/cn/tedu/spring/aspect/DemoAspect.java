package cn.tedu.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
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
        logger.debug("@Before 在{}时间，执行{}方法之前", LocalDateTime.now(), method);
    }

    /**
     * after 方法在 userServiceImpl bean的全部方法之前（@After）执行
     * @After 方法无论是否出现异常都会执行
     * @param joinPoint
     */
    @After("bean(userServiceImpl)")
    public void after(JoinPoint joinPoint){
        // Signature 签名，这里是方法签名=方法名+参数类型列表
        Signature method = joinPoint.getSignature();
        logger.debug("@After 在{}时间，执行{}方法之后", LocalDateTime.now(), method);
    }

    /**
     *  afterThrowing 会在 userServiceImpl 的全部方法正常执行结束以后执行
     * @param joinPoint 连接点，就是被调用方法
     * @param value 返回值，就是方法正常结束的返回值
     *              如果是login方法，则value就应该的登录成功的用户信息
     */
    @AfterReturning(pointcut = "bean(userServiceImpl)", returning = "value")
    public void afterThrowing(JoinPoint joinPoint, Object value){
        Signature signature = joinPoint.getSignature();
        logger.debug("@AfterReturning 方法{}返回之后执行，返回值{}", signature, value);
    }

    /**
     * afterThrowing 在被拦截方法出现异常以后执行，e 就是方法出现的异常对象
     * @param joinPoint 连接点
     * @param e 方法抛出的异常
     */
    @AfterThrowing(pointcut = "bean(userServiceImpl)", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        Signature signature = joinPoint.getSignature();
        logger.debug("@AfterThrowing 方法 {} 出现异常: {}", signature, e.getMessage());
    }

}









