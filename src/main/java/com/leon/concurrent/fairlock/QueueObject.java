package com.leon.concurrent.fairlock;

/**
 * 在FairLock中使用的类
 * @Author leon
 * @Date 2019/5/16 14:38
 */
public class QueueObject {
    private boolean isNotified = false;
    public synchronized void doWait() throws InterruptedException {
        while (!isNotified) {
            this.wait();
        }
        this.isNotified = false;
    }
    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }

    public boolean equals(Object o) {
        return this == o;
    }
}
