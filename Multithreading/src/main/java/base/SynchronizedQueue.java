package base;

import java.util.ArrayList;
import java.util.Arrays;

public class SynchronizedQueue {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue tq = new TaskQueue();
        ArrayList<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        String s = tq.getTask();
                        System.out.println("执行任务：" + s + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            ts.add(t);
        }

        System.out.println(Arrays.toString(ts.toArray()));

        Thread add = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                String s = "t-" + Math.random();
                System.out.println("新增任务：" + s);
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
        Thread.sleep(10000);
        for (Thread t: ts
             ) {
            try {
                t.interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
