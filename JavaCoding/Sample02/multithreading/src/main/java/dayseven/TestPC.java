package dayseven;

/**
 * 生产者-消费者模型
 * 管程法
 */
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Product(container).start();
        new Consumer(container).start();
    }
}

// 生产者
class Product extends Thread {
    SynContainer synContainer;

    public Product(SynContainer synContainer) {
        this.synContainer = synContainer;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了"+i+"只鸡");
            synContainer.push(new Chicken(i));
        }
    }
}

// 消费者
class Consumer extends Thread {
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了 -> 第"+synContainer.pop().id+"只鸡");
        }
    }
}

// 产品
class Chicken {
    int id;
    public Chicken(int id) {
        this.id = id;
    }
}

// 缓冲区
class SynContainer {
    // 需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    // 容器计数器
    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken) {
        // 如果容器已满，等待消费者消费
        if (count == chickens.length) {
            // 通知消费者消费，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果容器未满，就需要增加产品
        chickens[count] = chicken;
        count++;
    }

    // 消费者消费产品
    public synchronized Chicken pop() {
        // 判断能否消费
        if(count == 0) {
            // 等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果可以消费
        count--;
        Chicken chicken = chickens[count];

        // 吃完了，通知生产者生产
        this.notifyAll();
        return chicken;
    }
}