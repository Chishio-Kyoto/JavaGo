package dayone;

public class Sample005 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new NewThread$1();
        t.start();
        Thread.sleep(1);
        t.interrupt();  // 中断t线程
        t.join();
        System.out.println("Main end");
    }
}

class NewThread$1 extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
        }
    }
}
