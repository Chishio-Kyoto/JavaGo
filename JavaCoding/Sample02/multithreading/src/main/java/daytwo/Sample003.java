package daytwo;

public class Sample003 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println("main start...");
            Thread t = new Thread(() -> {
                System.out.println("t thread start...");
                System.out.println("t thread end...");
            });
            t.start();
            t.setPriority(10);
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main end...");
            System.out.println("@@@@@@@@@@");
        }
    }
}
