package cn.tedu.spring.proxy;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyTests {
    Logger logger = LoggerFactory.getLogger(ProxyList.class);

    @Test
    public void proxyList(){
        List<String> list = new ProxyList<>(new ArrayList<>());
        list.add("Tom");
        list.add("Jerry");
        logger.debug("size {} list{}", list.size(), list);
    }

    @Test
    public void jdkProxyTest(){
        List<String> list = (List<String>) Proxy.newProxyInstance(
                ProxyTests.class.getClassLoader(), //当前类型的 类加载器
                new Class[]{List.class},           //代理对象实现的接口
                new ListInvocationHandler<String>(new ArrayList<>())); //调用处理器
        list.add("Tom");
        list.add("Jerry");
        logger.debug("size {} list{}", list.size(), list);
    }
}
