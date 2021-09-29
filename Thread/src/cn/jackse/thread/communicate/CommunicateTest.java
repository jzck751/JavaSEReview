package cn.jackse.thread.communicate;

/**
 * @Description: 线程通信
 * 使用两个线程打印1-100，线程1，线程2，交替打印
 * @author: Jack
 * @date: 2021年09月29日 9:58
 */
public class CommunicateTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}


class Number implements Runnable {
    private int number = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                //唤醒
                notify();

                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //阻塞
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}


