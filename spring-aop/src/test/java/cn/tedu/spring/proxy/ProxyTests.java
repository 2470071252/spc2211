package cn.tedu.spring.proxy;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ProxyTests {
    Logger logger = LoggerFactory.getLogger(ProxyList.class);

    @Test
    public void proxyList(){
        ProxyList<String> list = new ProxyList<>(new ArrayList<>());
        list.add("Tom");
        list.add("Jerry");
        logger.debug("size {} list{}", list.sise(), list);
    }
}
