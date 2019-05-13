package com.leon.concurrent.synchronize;

/**
 * 测试不同的线程能够进入同一个实例的不同同步方法
 * @Author leon
 * @Date 2019/5/8 13:26
 */
public class InstanceSynchronize {
    public synchronized void method1() {
        System.out.println("execute method1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void method2() {
        System.out.println("execute method2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 下面的代码说明了，两个线程执行实例的不同的方法。需要前一个线程释放实例上的锁，另一个线程才能执行方法.
        // 看持有的什么锁
        InstanceSynchronize instanceSynchronize = new InstanceSynchronize();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                instanceSynchronize.method1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                instanceSynchronize.method2();
            }
        });
        thread1.start();
        thread2.start();
    }
}
