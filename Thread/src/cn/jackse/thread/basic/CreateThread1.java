package cn.jackse.thread.basic;

/**
 * @Description:
 * @author: Jack
 * @date: 2021年09月27日 21:58
 */
public class CreateThread1 extends Thread {

    @Override
    public void run() {
        System.out.println("创建线程");
    }

    public static void main(String[] args) {
        CreateThread1 createThread1 = new CreateThread1();
        createThread1.start();
    }
}
