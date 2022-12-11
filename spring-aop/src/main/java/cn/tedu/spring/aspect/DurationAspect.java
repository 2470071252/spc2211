package cn.tedu.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 检查业务层方法的持续时间
 */
@Aspect
@Component
public class DurationAspect {
    Logger logger = LoggerFactory.getLogger(DurationAspect.class);

    @Around("bean(userServiceImpl)")
    public Object test(ProceedingJoinPoint joinPoint)
            throws Throwable{
        Signature signature = joinPoint.getSignature();
        long t1 = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long t2 = System.currentTimeMillis();
        logger.debug("{}方法耗时{}ms", signature, t2-t1);
        return result;
    }
}
