package cn.tedu.spring.proxy;

import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.ArrayList;

/**
 * List 类型的代理类，解决List类型的线程安全问题
 * @param <E>
 */
public class ProxyList<E> {
    private ArrayList<E> target;

    public ProxyList(ArrayList<E> list){
        target = list;
    }

    public boolean add(E e){
        //在 list 类型基础上，扩展了线程安全功能
        synchronized (this) {
            return target.add(e);
        }
    }

    public int sise(){
        synchronized (this){
            return target.size();
        }
    }

    public String toString(){
        synchronized (this){
            return target.toString();
        }
    }
}
