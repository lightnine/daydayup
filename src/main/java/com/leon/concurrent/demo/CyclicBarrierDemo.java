package com.leon.concurrent.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 展示CyclicBarrier简单实用
 * 创建两个线程,两个栅栏，可以看到两个线程都到达barrier1后才能继续执行，然后都到达barrier2继续执行
 * 并且在每个栅栏处都会执行指定的动作
 * @Author leon
 * @Date 2019/5/31 16:19
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("BarrierAction 1 executed");
            }
        };
        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("BarrierAction 2 executed");
            }
        };
        CyclicBarrier barrier1 = new CyclicBarrier(2, run1);
        CyclicBarrier barrier2 = new CyclicBarrier(2, run2);
        CyclicBarrierRunnable c1 = new CyclicBarrierRunnable(barrier1, barrier2);
        CyclicBarrierRunnable c2 = new CyclicBarrierRunnable(barrier1, barrier2);
        new Thread(c1).start();
        new Thread(c2).start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CyclicBarrierRunnable implements Runnable {
    private CyclicBarrier barrier1 = null;
    private CyclicBarrier barrier2 = null;

    public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 正在barrier1上等待");
            barrier1.await();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 正在barrier2上等待");
            barrier2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
