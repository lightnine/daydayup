package com.leon.jdkDemo;

import java.util.concurrent.CountDownLatch;

/**
 * 展示CountDownLatch的使用
 * @author leon
 * @since 2020/2/16 12:36
 */
class MyThread extends Thread {
    private CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(100);
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }
}
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new MyThread(latch).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count=" + latch.getCount());
        System.out.println("finished");
    }
}