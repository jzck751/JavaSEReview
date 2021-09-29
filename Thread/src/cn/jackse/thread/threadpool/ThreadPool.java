package cn.jackse.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: 创建线程的第四个方式：使用线程池
 * @author: Jack
 * @date: 2021年09月29日 11:36
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;

        NumThread numThread = new NumThread();

        //设置线程池的属性
        System.out.println(executorService.getClass());



        //适合适用于Runnable
        executorService.execute(numThread);

        //适合适用于Callable
//        executorService.submit()

        //关闭线程池
        executorService.shutdownNow();
    }
}

class NumThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
