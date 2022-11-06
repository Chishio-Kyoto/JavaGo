package daytwo;

public class Sample005 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start...");
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt();  // 中断t线程
        t.join();  // 等待t线程结束
        System.out.println("main end ...");
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread start...");
        Thread hello = new HelloThread();
        hello.start();  // 启动hello线程
        try {
            hello.join();  // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        // 对hello线程进行interrupt()调用通知其中断
        hello.interrupt();
        System.out.println("MyThread end...");
    }
}

class HelloThread extends Thread {
    public void run() {
        System.out.println("HelloThread start...");
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("HelloThread end...");
    }
}