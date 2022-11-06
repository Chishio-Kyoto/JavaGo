package daytwo;

import java.time.LocalTime;

public class Sample007 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start...");

        TimerThread t2 = new TimerThread();
        // 未设置为守护进程时，main线程结束，t线程仍一直执行
        t2.setDaemon(true);
        t2.start();
        Thread.sleep(1000);
        Thread.currentThread().interrupt();
        System.out.println("main end...");
    }
}

class TimerThread extends Thread {
    @Override
    public void run() {
        System.out.println("TimerThread start...");
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("TimerThread end...");
    }
}