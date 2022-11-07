package daysix;

public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station, "路人甲").start();
        new Thread(station, "黄牛甲").start();
        new Thread(station, "黄牛乙").start();
    }
}


class BuyTicket implements Runnable {

    private int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void buy() throws InterruptedException {
        if (ticketNums <= 0) {
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "抢到" + ticketNums--);
    }
}