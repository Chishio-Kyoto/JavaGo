package daytwo;

public class Sample010 {
    public static void main(String[] args) throws InterruptedException {
        AddThreadY add = new AddThreadY();
        DecThreadY dec = new DecThreadY();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(CounterY.count);
    }
}

class CounterY {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    public static int count = 0;
}

class AddThreadY extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(CounterY.lock1) {
                Counter.count += 1;
            }
        }
    }
}

class DecThreadY extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(CounterY.lock2) {
                Counter.count -= 1;
            }
        }
    }
}