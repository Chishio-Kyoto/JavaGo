package base;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new SampleThread();
        t.start();
        Thread.sleep(100);
        t.interrupt();
        t.join();
        System.out.println("end~");
    }
}

class SampleThread extends Thread {
    @Override
    public void run() {
        System.out.println("Sample Thread start...");
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello~");
        }
    }
}
