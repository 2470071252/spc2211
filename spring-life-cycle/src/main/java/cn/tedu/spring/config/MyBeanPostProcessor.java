package cn.tedu.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 每一个Java Bean 创建以后，都会执行 BPP 的两个
 * 这个两方法分别在Bean初始化方法之前和之后执行
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    Logger logger = LoggerFactory.getLogger(MyBeanPostProcessor.class);
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        //创建了每个一个bean以后，执行初始化方法之前，执行
        //bean 就是刚刚创建的Bean对象， beanName就是这个Bean ID
        logger.debug("初始化前置处理 {} {} ", beanName, bean);
        //方法务必返回 bean 对象，否则会干扰 执行Bean初始化方法
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        //在每个Bean初始化以后执行后置处理方法
        logger.debug("初始化后置处理 {} {} ", beanName, bean);
        //方法务必返回 bean 对象，否则会干扰Bean的使用
        return bean;
    }
}
