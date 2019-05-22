package com.leon.concurrent.demo;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * DelayQueue
 * @Author leon
 * @Date 2019/5/17 11:16
 */
public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue queue = new DelayQueue();
        Delayed element1 = new DelayedElement();
        queue.put(element1);
        Delayed element2 = queue.take();
        System.out.println(element2);
    }
}

class DelayedElement implements Delayed {

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
