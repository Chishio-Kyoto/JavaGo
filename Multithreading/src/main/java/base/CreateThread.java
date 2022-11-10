package base;

public class CreateThread {
    public static void main(String[] args) {
        Thread thread1 = new HelloThread();
        Thread thread2 = new Thread(new Hello2Thread());
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello3 Thread");
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello Thread");
    }
}

// 推荐方式
class Hello2Thread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello2 Thread");
    }
}