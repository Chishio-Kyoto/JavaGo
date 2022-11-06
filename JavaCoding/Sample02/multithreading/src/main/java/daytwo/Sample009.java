package daytwo;

public class Sample009 {
    public static void main(String[] args) throws InterruptedException {
        AddThreadX add = new AddThreadX();
        DecThreadX dec = new DecThreadX();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(CounterX.count);
    }
}

class CounterX {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThreadX extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (Counter.lock) {
                Counter.count += 1;
            }
        }
    }
}

class DecThreadX extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (Counter.lock) {
                Counter.count -= 1;
            }
        }
    }
}