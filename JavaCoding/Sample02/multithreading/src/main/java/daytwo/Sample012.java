package daytwo;

public class Sample012 {
    public static void main(String[] args) {
        CounterB counterB = new CounterB();
        for (int i = 0; i < 1000; i++) {
            counterB.add(1);
        }
        System.out.println(counterB.getCount());  // 1000
        for (int i = 0; i < 1000; i++) {
            counterB.add(-1);
        }
        System.out.println(counterB.getCount());  // 2000
    }
}

class CounterB {
    private int count = 0;

    public synchronized void add(int n) {
        if (n<0) {
            dec(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec(int n) {
        count += n;
    }

    public int getCount() {
        return count;
    }
}