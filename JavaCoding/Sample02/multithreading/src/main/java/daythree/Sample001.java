package daythree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Sample001 {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue tq = new TaskQueue();
        ArrayList<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        String s = tq.getTask();
                        System.out.println("execute task: " + s + " execute thread: " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            });
            t.start();
            ts.add(t);
        }

        System.out.println(Arrays.toString(ts.toArray()));

        Thread add = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                tq.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread t: ts
             ) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
            System.out.println(Thread.currentThread().getName());
        }
        return queue.remove();
    }
}