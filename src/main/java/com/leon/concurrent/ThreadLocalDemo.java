package com.leon.concurrent;

/**
 * ThreadLocal 例子
 *
 * @Author leon
 * @Date 2019/5/13 13:37
 */
public class ThreadLocalDemo {
    public static class MyRunnable implements Runnable {
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            // 100 后的D表示是double类型
            threadLocal.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) {
        // the InheritableThreadLocal grants access to values to a thread
        // and all child threads created by that thread.
        // InheritableThreadLocal，
        MyRunnable shareInstance = new MyRunnable();
        Thread thread1 = new Thread(shareInstance);
        Thread thread2 = new Thread(shareInstance);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
