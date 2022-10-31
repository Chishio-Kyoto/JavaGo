package daytwo;

public class Sample013 {
    public static void main(String[] args) throws InterruptedException {
        AddThreadA a = new AddThreadA();
        DecThreadB b = new DecThreadB();
        DecThreadC c = new DecThreadC();
        a.start();
        // b.start();
        c.start();
        a.join();
        // b.join();
        c.join();
        System.out.println(Count1.count);
        System.out.println(Count2.count);
    }
}

class Count1 {
    public static final Object lock = new Object();
    public static int count = 0;
}

class Count2 {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThreadA extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Count1.lock) {  // 获取Count1的锁
                Count1.count += 1;
                synchronized (Count2.lock) {  // 获取Count2的锁
                    Count2.count += 1;
                }  // 释放Count2的锁
            }  // 释放Count1的锁
        }
    }
}

class DecThreadB extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Count2.lock) {  // 获取Count2的锁
                Count2.count -= 1;
                synchronized (Count1.lock) {  // 获取Count1的锁
                    Count1.count -= 1;
                }  // 释放Count1的锁
            }  // 释放Count2的锁
        }
    }
}

class DecThreadC extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Count1.lock) {  // 获取Count1的锁
                Count1.count -= 1;
                synchronized (Count2.lock) {  // 获取Count2的锁
                    Count2.count -= 1;
                }  // 释放Count2的锁
            }  // 释放Count1的锁
        }
    }
}