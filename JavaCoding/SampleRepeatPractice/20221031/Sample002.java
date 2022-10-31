package daytwo;

/**
 * 模拟并发执行
 */
public class Sample002 {
    public static void main(String[] args) {
        System.out.println("main start...");
        Thread t = new Thread(() -> {
            System.out.println("t thread start...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t thread end...");
        });
        t.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end...");
    }
}
