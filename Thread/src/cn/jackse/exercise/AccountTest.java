package cn.jackse.exercise;

/**
 * @Description: 银行有一个账户
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额
 * <p>
 * 解析：
 * 1、是否是多线程问题？时，两个储户
 * 2、是否有共享数据？有，账户
 * 3、是否有线程安全问题？有，需要考虑如何解决线程安全问题，使用同步机制：有三种方式
 * @author: Jack
 * @date: 2021年09月28日 21:30
 */
class Account {
    private Double balance;

    public Account(Double balance) {
        this.balance = balance;
    }

    //存钱的方法
    public synchronized void deposit(Double amount) {
        if (amount > 0) {
            balance += amount;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":存钱成功！余额为：" + balance);
        }
    }
}

class Customer extends Thread {
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000.0);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0.0);

        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
