package base;

public class DieThread {
    public static void main(String[] args) throws InterruptedException {
        AddThread1 thread1 = new AddThread1();
        DecThread1 thread2 = new DecThread1();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(CountA.count);
        System.out.println(CountB.count);
    }
}

class CountA {
    public static final Object lock = new Object();
    public static int count = 0;
}

class CountB {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            add();
        }
    }

    public void add() {
        synchronized(CountA.lock) {  // 获得lockA的锁
            CountA.count ++;
            synchronized(CountB.lock) {  // 获得lockB的锁
                CountB.count ++;
            }  // 释放lockB的锁
        }  // 释放lockA的锁
    }
}

class DecThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            dec();
        }
    }

    public void dec() {
        synchronized(CountB.lock) {  // 获得lockB的锁
            CountB.count ++;
            synchronized(CountA.lock) {  // 获得lockA的锁
                CountA.count ++;
            }  // 释放lockA的锁
        }  // 释放lockB的锁
    }
}