package com.leon.concurrent.fairlock;

import java.util.ArrayList;
import java.util.List;

/**
 * 公平锁
 * 当有线程想要获取锁，首先进入等待队列，如果能获取，则获取锁；不能获取则等待
 * 当线程释放锁时，会唤醒等待队列中的第一个线程。
 * 注意每个线程都会创建自己的QueueObject对象，这样就能做到唤醒对应的线程
 * @Author leon
 * @Date 2019/5/16 14:36
 */
public class FairLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException {
        QueueObject queueObject = new QueueObject();
        boolean isLockedForThisThread = true;
        synchronized (this) {
            waitingThreads.add(queueObject);
        }
        while (isLockedForThisThread) {
            synchronized (this) {
                isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;
                if (!isLockedForThisThread) {
                    isLocked = true;
                    waitingThreads.remove(queueObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            try {
                queueObject.doWait();
            } catch (InterruptedException e) {
                synchronized (this) {
                    waitingThreads.remove(queueObject);
                    throw e;
                }
            }
        }
    }

    public synchronized void unLock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        if (waitingThreads.size() > 0) {
            // 唤醒等待队列中的第一个线程
            waitingThreads.get(0).doNotify();
        }
    }
}
