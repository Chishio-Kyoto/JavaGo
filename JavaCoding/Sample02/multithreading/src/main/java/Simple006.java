package dayone;

public class Simple006 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread$2();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}

class MyThread$2 extends Thread {
    public void run() {
        Thread hello = new HelloThread();
        hello.start();  // 启动hello线程
        try {
            hello.join();  // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted MyThread$2!");
        }
        hello.interrupt();
    }
}

class HelloThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("interrupted HelloThread!");
                break;
            }
        }
    }
}
