package com.leon.jdkDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier使用
 *
 * 从运行结构可以看出，先启动的任务几乎同时完成，而后完成的任务结束时间比前两个线程完成时间晚16ms,其中6ms是启动线程所花费的。主线程中sleep 300ms 是为了等待所有的线程都执行完成。也可以使用join实现相同的效果。在这里解释一下为什么不能像CountDownLatch一样用主线程作为等待线程。我刚开始也是这样做的，发现主线程一下就跑完了，根本不停。
 * 查看了源码才发现，CyclicBarrier没有park主线程。具体逻辑相见下文的原理分析。
 * @author leon
 * @since 2020/2/16 12:43
 */
// 先完成的任务
class NormalTask implements Runnable {
    CyclicBarrier barrier;

    NormalTask(CyclicBarrier barrier) {
        this.barrier = barrier;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(100);
            barrier.await();
            System.out.println(System.currentTimeMillis() + " first step finished");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
// 后完成的任务
class FinalTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() + " second step finished");
    }
}
public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(2, new FinalTask());
        new Thread(new NormalTask(barrier)).start();
        new Thread(new NormalTask(barrier)).start();
        Thread.sleep(300);
    }

}
