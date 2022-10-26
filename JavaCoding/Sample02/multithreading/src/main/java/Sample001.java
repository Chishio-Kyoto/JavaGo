public class Sample001 {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();

        Thread t3 = new Thread(() -> {
            System.out.println("start new thread 3!");
        });
        t3.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread 1!");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread 2!");
    }
}