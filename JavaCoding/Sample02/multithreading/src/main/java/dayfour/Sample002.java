package dayfour;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Sample002 {
    public static void main(String[] args) {

        MyCacheLock myCache = new MyCacheLock();
        // 写操作
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.set(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        // 读操作
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

class MyCacheLock{

    private final Map<String,Object> map = new HashMap<>();
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();  // 定义读写锁

    // 写操作
    public void set(String key,Object value){
        readWriteLock.writeLock().lock();  // 加上写锁
        try {
            System.out.println(Thread.currentThread().getName()+" 写入了 "+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+" 写入操作完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();  // 释放写锁
        }

    }

    // 读操作
    public void get(String key){
        readWriteLock.readLock().lock();  // 加上读锁
        try {
            System.out.println(Thread.currentThread().getName()+" 读取了 "+key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+" 读取操作完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();  // 释放读锁
        }

    }
}