package cn.tedu.spring.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ListInvocationHandler<E> implements InvocationHandler {
    Logger logger = LoggerFactory.getLogger(ListInvocationHandler.class);
    private ArrayList<E> target;

    public ListInvocationHandler(ArrayList<E> list){
        target = list;
    }

    @Override
    public Object invoke(  //Object 表示方法的返回值
            Object proxy,  // 当前代理对象
            Method method, // 正在被调用的方法
            Object[] args  // 调用方法传递的实际参数
            ) throws Throwable { //方法执行出现的异常
        synchronized (proxy) {
            //利用反射API调用目标对象的方法
            logger.debug("调用方法{}", method);
            return method.invoke(target, args);
        }
    }
}
