package daytwo;

public class Sample006 {
    public static void main(String[] args) throws InterruptedException {
        OtherThread t = new OtherThread();
        t.start();
        Thread.sleep(1);
        t.running = false;
    }
}

class OtherThread extends Thread {
    // 设置标识位
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}