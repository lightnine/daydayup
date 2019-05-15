package com.leon.concurrent.waitNotify;

/**
 * 演示如何采用wait notify进行线程之间的信号通知
 * 调用，wait会释放锁，但是在被唤醒时，且调用notify方法的线程退出synchronized。wait的线程会再次获取锁
 * 然后执行后续的操作
 * @Author leon
 * @Date 2019/5/14 19:43
 */
public class WaitNofityDemo {
    public static Object object = new Object();
    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("thread " + Thread.currentThread() + " get lock");
                try {
                    object.wait();
                    System.out.println("after wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread " + Thread.currentThread() + " get lock");
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("thread " + Thread.currentThread() + " enter synchronized");
                object.notify();
                System.out.println("thread " + Thread.currentThread() + " after notify");
            }
            System.out.println("thread " + Thread.currentThread() + " release lock");
        }
    }
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
