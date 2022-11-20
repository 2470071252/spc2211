package cn.tedu.spring;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Demo {
    public static void main(String[] args) {
        long t1 = System.nanoTime();
        System.out.println("Hello World!");
        long t2 = System.nanoTime();
        System.out.println("时间:"+(t2-t1));
        BlockingQueue<String> queue =
                new ArrayBlockingQueue<>(100);
        t1 = System.nanoTime();
        queue.add("Hello World!");
        t2 = System.nanoTime();
        System.out.println("时间:"+(t2-t1));
    }
}
