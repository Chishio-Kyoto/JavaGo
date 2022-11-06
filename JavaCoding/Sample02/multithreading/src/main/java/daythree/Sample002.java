package daythree;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sample002 {
    public static void main(String[] args) throws InterruptedException {
        CounterA counterA = new CounterA();
        for (int i = 0; i < 10000; i++) {
            counterA.add(1);
            counterA.dec(1);
        }
        System.out.println(counterA.getCount());
    }
}

class CounterA {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) throws InterruptedException {
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            lock.lock();;
            try {
                count += n;
            } finally {
                lock.unlock();
            }
        }
    }

    public void dec(int n) throws InterruptedException {
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            lock.lock();
            try {
                count -= n;
            } finally {
                lock.unlock();
            }
        }
    }

    public int getCount() {
        return count;
    }
}