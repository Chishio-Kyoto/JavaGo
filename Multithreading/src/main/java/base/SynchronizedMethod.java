package base;

public class SynchronizedMethod {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        for (int i = 0; i < 10000; i++) {
            counter1.add(i);
        }
        for (int i = 0; i < 10000; i++) {
            counter1.dec(i);
        }
        for (int i = 0; i < 10000; i++) {
            counter2.add(i);
        }
        for (int i = 0; i < 10000; i++) {
            counter2.dec(i);
        }
        System.out.println(counter1.count);
        System.out.println(counter2.count);
    }

    static class Counter {
        private int count = 0;
        public void add(int n) {
            synchronized (this) {
                count += n;
            }
        }

        public void dec(int n) {
            synchronized (this) {
                count -= n;
            }
        }

        public int getCount() {
            return count;
        }
    }
}