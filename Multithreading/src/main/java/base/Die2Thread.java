package base;

public class Die2Thread {
    public static void main(String[] args) throws InterruptedException {
        AddThread1X thread1 = new AddThread1X();
        DecThread1X thread2 = new DecThread1X();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(CountA.count);
        System.out.println(CountB.count);
    }
}

class CountAX {
    public static final Object lock = new Object();
    public static int count = 0;
}

class CountBX {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread1X extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            add();
        }
    }

    public void add() {
        synchronized(CountAX.lock) {  // 获得lockAX的锁
            CountAX.count ++;
            synchronized(CountBX.lock) {  // 获得lockBX的锁
                CountBX.count ++;
            }  // 释放lockBX的锁
        }  // 释放lockAX的锁
    }
}

class DecThread1X extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            dec();
        }
    }

    public void dec() {
        synchronized(CountAX.lock) {  // 获得lockAX的锁
            CountBX.count ++;
            synchronized(CountBX.lock) {  // 获得lockBX的锁
                CountAX.count ++;
            }  // 释放lockBX的锁
        }  // 释放lockAX的锁
    }
}