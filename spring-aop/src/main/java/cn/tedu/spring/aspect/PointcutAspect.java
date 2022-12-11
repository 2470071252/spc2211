package cn.tedu.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PointcutAspect {
    Logger logger = LoggerFactory.getLogger(PointcutAspect.class);
    /**
     * 创建一个空方法，在方法上标注 @Pointcut
     * 并且设置对应的 切入点表达式，选择切入位置
     * 以后使用方法名，代表切入点。
     */
    //@Pointcut("bean(userServiceImpl)||bean(awardServiceImpl)")
    //@Pointcut("execution(* *Service.*(..))") //选择业务层接口全部方法
    //@Pointcut("execution(* *..UserService.get*(..))") //选择UserService的全部getXXX方法
    @Pointcut("execution(*..User *Service.get*(*))")//选择业务层get开头方法返回User类型
    public void allServiceBean(){}

    /**
     * allServiceBean() 就是前述定义的 切入点方法名
     */
    @Before("allServiceBean()")
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        logger.debug("{}", signature);
    }
}
