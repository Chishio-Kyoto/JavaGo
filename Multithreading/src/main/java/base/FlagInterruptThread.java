package base;

public class FlagInterruptThread {
    public static void main(String[] args) throws InterruptedException {
        FuckThread t = new FuckThread();
        t.start();
        Thread.sleep(100);
        t.running = false;
        System.out.println("main end");
    }
}

class FuckThread extends Thread {
    public volatile boolean running = true;

    @Override
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " hello~");
        }
        System.out.println("end!");
    }
}
