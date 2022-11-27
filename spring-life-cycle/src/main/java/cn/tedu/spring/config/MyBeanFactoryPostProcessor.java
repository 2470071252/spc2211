package cn.tedu.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    Logger logger = LoggerFactory.getLogger(MyBeanFactoryPostProcessor.class);
    /**
     * Bean工厂后期处理方法，在加载了全部的Bean定义以后自动执行。
     * @param beanFactory 当前Bean工厂，包含全部的Bean定义信息
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        //在这里可以，添加、删除、处理Bean的定义！！！
        for (String name: beanNames){
            logger.debug("{}", name);
        }
    }
}
