package daytwo;

public class Sample011 {
    public static void main(String[] args) {
        CounterZ counterZ1 = new CounterZ();
        CounterZ counterZ2 = new CounterZ();

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                counterZ1.add(1);
            }).start();
            new Thread(() -> {
                counterZ1.dec(1);
            }).start();
        }
        System.out.println(counterZ1.getCount());
        System.out.println(counterZ2.getCount());

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                counterZ2.add(1);
            }).start();
            new Thread(() -> {
                counterZ2.dec(1);
            }).start();
        }
        System.out.println(counterZ1.getCount());
        System.out.println(counterZ2.getCount());
    }

}

class CounterZ {
    private int count = 0;

    public void add(int n) {
        synchronized (this) {
            count += n;
        }
    }

    public void dec(int n) {
        synchronized(this) {
            count -= n;
        }
    }

    public int getCount() {
        synchronized(this) {
            return count;
        }
    }
}