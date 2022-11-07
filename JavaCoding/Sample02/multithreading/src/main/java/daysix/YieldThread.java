package daysix;

public class YieldThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread t1");
            System.out.println(Thread.currentThread().getName() + "开始执行");
            // Thread.yield();
            System.out.println(Thread.currentThread().getName() + "结束执行");
        }, "t1");

        Thread t2 = new Thread(() -> {
            System.out.println("Thread t2");
            System.out.println(Thread.currentThread().getName() + "开始执行");
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + "结束执行");
        }, "t2");

        t1.start();
        t2.start();
    }
}