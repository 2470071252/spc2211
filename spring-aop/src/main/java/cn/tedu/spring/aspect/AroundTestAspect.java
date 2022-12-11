package cn.tedu.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
//@Component
public class AroundTestAspect {
    Logger logger = LoggerFactory.getLogger(AroundTestAspect.class);
    /**
     * @Around 环绕通知，环绕目标方法执行
     *         @Around 是万能通知，可以代替 其他4个通知！
     * @param joinPoint 代表连接点
     * @return 返回目标方法处理结果
     * @throws Throwable 抛出业务方法执行异常
     */
    @Around("bean(userServiceImpl)")
    public Object test(ProceedingJoinPoint joinPoint)
        throws Throwable{
        Signature signature = joinPoint.getSignature();

        try {
            logger.debug("@Around 在{}方法之前", signature);
            //调用后续的目标业务方法，原则上必须调用！！
            Object result = joinPoint.proceed();
            logger.debug("@Around 在{}方法之之后", signature);
            return result; //返回目标方法的执行结果
            //return null; //这里可以对结果进行转换处理
        }catch (Throwable e){
            logger.debug("@Around 方法出现异常 {}", e.getMessage());
            throw e; //异常原则上必须抛出异常，这里可以对异常进行转换处理
        }finally {
            logger.debug("@Around方法之后");
        }

    }
}
