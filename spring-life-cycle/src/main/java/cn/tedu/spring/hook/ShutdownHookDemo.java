package cn.tedu.spring.hook;

public class ShutdownHookDemo {
    public static void main(String[] args) throws Exception{
        /*
         * runtime 运行时
         * total 总数
         * Memory 记忆，内存，记忆体
         * shutdown 关机
         * Hook 钩子
         * runtime 代表正在运行的虚拟机
         * 可以通过runtime获取当前虚拟机的参数
         */
        Runtime runtime = Runtime.getRuntime();
        //获取当前JVM总内存数量
        long bytes = runtime.totalMemory();
        System.out.println("totalMemory:" + bytes);
        //给系统挂关闭钩子
        runtime.addShutdownHook(new DemoHook());
        System.out.println("挂完了");
        Thread.sleep(2000);
    }
}

class DemoHook extends Thread{
    @Override
    public void run() {
        System.out.println("执行钩子了！");
    }
}
