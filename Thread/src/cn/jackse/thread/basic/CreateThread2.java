package cn.jackse.thread.basic;

/**
 * @Description:
 * @author: Jack
 * @date: 2021年09月27日 22:01
 */
public class CreateThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("创建线程成功");
    }

    public static void main(String[] args) {
        CreateThread2 createThread2 = new CreateThread2();
        Thread t1 = new Thread(createThread2);
        Thread t2 = new Thread(createThread2);
        Thread t3 = new Thread(createThread2);

        t1.start();
        t2.start();
        t3.start();
    }
}
