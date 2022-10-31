package daytwo;

public class Sample008 {
    public static void main(String[] args) throws InterruptedException {
        AddThread add = new AddThread();
        DecThread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }
}

class Counter {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Counter.count += 1;
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Counter.count -= 1;
        }
    }
}