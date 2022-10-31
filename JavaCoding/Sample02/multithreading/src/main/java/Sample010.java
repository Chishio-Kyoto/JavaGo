package dayone;

public class Sample010 {
    public static void main(String[] args) {
        CounterX c1 = new CounterX();
        CounterX c2 = new CounterX();

        // 对c1进行操作的线程:
        new Thread(() -> {
            c1.add(1);
        }).start();
        new Thread(() -> {
            c1.dec(1);
        }).start();

        // 对c2进行操作的线程:
        new Thread(() -> {
            c2.add(1);
        }).start();
        new Thread(() -> {
            c2.dec(1);
        }).start();
    }
}
