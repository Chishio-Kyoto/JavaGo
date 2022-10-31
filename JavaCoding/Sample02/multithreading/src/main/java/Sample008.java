package dayone;

import java.time.LocalTime;

public class Sample008 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.setDaemon(true);
        t.start();

        TimerThread t2 = new TimerThread();
        t2.start();
    }
}

class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}