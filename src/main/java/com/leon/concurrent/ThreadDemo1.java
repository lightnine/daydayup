package com.leon.concurrent;

/**
 * thread basic use
 * @Author leon
 * @Date 2019/5/6 18:41
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
//        thread.start();
        thread.run();
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        System.out.println("MyThread run");
    }
}
