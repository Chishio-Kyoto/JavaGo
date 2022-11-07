package daysix;

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(10000, "结婚基金");
        Bank people1 = new Bank(account, 5000);
        Bank people2 = new Bank(account, 8000);
        Thread t1 = new Thread(people1, "男主人公");
        Thread t2 = new Thread(people2, "女主人公");
        t1.start();
        t2.start();
    }
}

class Bank implements Runnable {

    Account account;
    int drawingMoney;
    int nowMoney;

    public Bank(Account account, int drawingMoney) {
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        int accountMoney = account.getMoney();
        if (account.getMoney() - drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
        }
        accountMoney -= drawingMoney;
        nowMoney += drawingMoney;

        System.out.println(account.getName() + "余额：" + accountMoney);
        System.out.println(Thread.currentThread().getName() + "手里的钱：" + nowMoney);
    }
}

class Account {
    private final int money;
    private final String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}