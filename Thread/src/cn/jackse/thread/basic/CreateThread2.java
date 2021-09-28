package cn.jackse.thread.basic;

/**
 * @Description:
 * @author: Jack
 * @date: 2021年09月27日 22:01
 */
public class CreateThread2 implements Runnable {
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"：卖票，票号为："+ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        CreateThread2 window = new CreateThread2();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
