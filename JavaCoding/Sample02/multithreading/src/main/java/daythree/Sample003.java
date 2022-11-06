package daythree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sample003 {
}

class TaskQueueNew {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        // this.queue.add(s);
        // this.notifyAll();
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public synchronized String getTask() throws InterruptedException {
        /*
        while (queue.isEmpty()) {
            this.wait();
            System.out.println(Thread.currentThread().getName());
        }
        return queue.remove();
        */
        try {
            lock.lock();
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}