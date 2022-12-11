package cn.tedu.spring.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ArrayListInterceptor<E> implements MethodInterceptor {
    Logger logger = LoggerFactory.getLogger(ArrayListInterceptor.class);
    private ArrayList<E> target;
    public ArrayListInterceptor(ArrayList<E> list){
        target = list;
    }
    @Override
    public Object intercept(Object proxy,
                            Method method,
                            Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        synchronized (proxy) {
            logger.debug("CGLib {}", method);
            return method.invoke(target, args);
        }
    }
}
