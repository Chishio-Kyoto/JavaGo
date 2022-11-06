package dayfour;

import java.util.HashMap;
import java.util.Map;

public class Sample001 {
    public static void main(String[] args) throws InterruptedException {
        MyCache myCache = new MyCache();
        // 写操作
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.set(temp+"", temp+"@");
            }, String.valueOf(i)).start();
        }

        // 读操作
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp+"");
            }, String.valueOf(i)).start();
        }
    }
}

class MyCache {
    private final Map<String, Object> map = new HashMap<>();

    // 写操作
    public void set(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + " 写入了 " + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + " 写入操作完成 ");
    }

    // 读操作
    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + " 读取了 " + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + " 读取操作完成 ");
    }
}