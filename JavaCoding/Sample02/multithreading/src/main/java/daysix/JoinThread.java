package daysix;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        People people = new People();
        Thread thread = new Thread(people);
        thread.start();

        // 主线程
        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                thread.join();
            }
            System.out.println("Main线程：" + i);
        }
    }
}

class People implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程VIP来了" + i);
        }
    }
}
