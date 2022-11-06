package daytwo;

public class Sample004 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread running~");
        Thread t = new Thread( () -> {
            System.out.println("t thread running~");
            int n = 0;
            while(!Thread.currentThread().isInterrupted()) {
                n++;
                System.out.println("@@@ " + n);
            }
        } );
        t.start();
        Thread.sleep(2);
        t.interrupt();
        t.join();
        System.out.println("t thread end~");
        System.out.println("main thread end~");
    }
}
