package daysix;

public class SafeBuyTicket {
    public static void main(String[] args) {
        BuyTicketPlus station = new BuyTicketPlus();

        new Thread(station, "路人甲").start();
        new Thread(station, "黄牛甲").start();
        new Thread(station, "黄牛乙").start();
    }
}

class BuyTicketPlus implements Runnable {

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

    // synchronized 同步方法，锁的是this
    private synchronized void buy() throws InterruptedException {
        if (ticketNums <= 0) {
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "抢到" + ticketNums--);
    }
}
