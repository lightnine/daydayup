package com.leon.concurrent.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * ClassName DeadLock
 * Description: 展示死锁产生, 即线程1先对A加锁,在请求对B加锁
 * 线程2先对B加锁，再请求对A加锁
 * Create by leon's melody
 * Date 2020/6/25 16:17
 */
public class DeadLock {
    private static Object lockA = new Object();
    private static Object lockB = new Object();
    public void deadLock() {
        Thread threadA = new Thread(() -> {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "获取A成功");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "尝试获取B");
                    synchronized (lockB) {
                        System.out.println(Thread.currentThread().getName() + "获取B成功");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(() -> {
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "获取B成功");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "尝试获取A");
                    synchronized (lockA) {
                        System.out.println(Thread.currentThread().getName() + "获取A成功");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.deadLock();
    }
}
