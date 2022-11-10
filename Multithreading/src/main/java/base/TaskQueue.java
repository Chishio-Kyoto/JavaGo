package base;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    // 往队列中添加任务
    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    // 从队列中获取任务
    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
            System.out.println("线程：" + Thread.currentThread().getName() + " 等待中～");
        }
        return queue.remove();
    }
}
