package dayone;

public class Sample1028 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread t1 is running~");
        });
        t1.start();

        NewThread t2 = new NewThread();
        t2.start();

        Thread t3 = new Thread(new NewRunnable());
        t3.start();
    }


}

class NewThread extends Thread {
    @Override
    public void run(){
        System.out.println("Thread is running~");
    }
}

class NewRunnable implements Runnable {
    @Override
    public void run(){
        System.out.println("Thread is running~");
    }
}