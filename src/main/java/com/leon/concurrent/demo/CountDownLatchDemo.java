package com.leon.concurrent.demo;

import java.util.concurrent.CountDownLatch;

/**
 * 展示CountDownLatch简单实用
 * @Author leon
 * @Date 2019/5/31 15:48
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        Waiter waiter = new Waiter(latch);
        Desc desc = new Desc(latch);
        Thread thread1 = new Thread(waiter);
        Thread thread2 = new Thread(desc);
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Waiter implements Runnable {
    private CountDownLatch latch = null;

    public Waiter(CountDownLatch countDownLatch) {
        this.latch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("进入waiter");
            latch.await();
            System.out.println("退出waiter");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Desc implements Runnable {
    private CountDownLatch latch = null;

    public Desc(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("desc 减 1");
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("desc 减 2");
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("desc 减 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
