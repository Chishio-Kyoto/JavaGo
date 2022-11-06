package daytwo;

public class Sample001 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run() {
                System.out.println("a thread is running~");
            };
        };

        // 推荐
        Thread t2 = new Thread(() -> {
            System.out.println("a thread is running~");
        });

        t1.start();

        t2.start();

        Thread t3 = new ThreadType1();
        t3.start();

        Thread t4 = new Thread(new ThreadType2());
        t4.start();
    }
}

class ThreadType1 extends Thread {
    @Override
    public void run() {
        System.out.println("a thread is running~");
    }
}

class ThreadType2 implements Runnable {

    @Override
    public void run() {
        System.out.println("a thread is running~");
    }
}
