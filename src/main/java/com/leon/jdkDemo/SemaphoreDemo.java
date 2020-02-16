package com.leon.jdkDemo;

import java.util.concurrent.*;

/**
 * Semaphore使用
 * 这里展示了Semaphore用于控制有多少个线程可以同时运行
 *
 * @author leon
 * @since 2020/2/16 17:27
 */
public class SemaphoreDemo {
    // 请求的数量
    private static final int threadCount = 400;

    public static void main(String[] args) {
//        ArrayBlockingQueue workQueue = new ArrayBlockingQueue(10);
//        ExecutorService threadPool = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, workQueue);
        // 线程池,有300个线程
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        // 一次允许执行的线程数量
        final Semaphore semaphore = new Semaphore(20);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    // 获取一个许可
                    semaphore.acquire();
                    test(threadNum);
                    // 释放一个许可
                    semaphore.release();
                } catch (InterruptedException ex) {
                    System.out.println("thread num:" + threadNum);
                    ex.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadNum) throws InterruptedException {
        // 模拟请求的耗时操作
        Thread.sleep(1000);
        System.out.println("threadNum:" + threadNum);
        Thread.sleep(1000);
    }
}
