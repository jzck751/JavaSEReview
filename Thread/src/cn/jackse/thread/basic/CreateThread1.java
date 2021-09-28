package cn.jackse.thread.basic;

/**
 * @Description:
 * @author: Jack
 * @date: 2021年09月27日 21:58
 */
public class CreateThread1 extends Thread {
    private int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
//        System.out.println("创建线程");
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        CreateThread1 win1 = new CreateThread1();
        CreateThread1 win2 = new CreateThread1();
        CreateThread1 win3 = new CreateThread1();

        win1.setName("窗口1");
        win2.setName("窗口2");
        win3.setName("窗口3");

        win1.start();
        win2.start();
        win3.start();
    }
}
