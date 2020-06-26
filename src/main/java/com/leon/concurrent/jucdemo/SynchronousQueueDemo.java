package com.leon.concurrent.jucdemo;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * ClassName SynchronousQueueDemo
 * Description: 展示SynchronousQueue的使用
 * Create by leon's melody
 * Date 2020/6/25 11:28
 */
public class SynchronousQueueDemo {
    static class SynchronousQueueProducer implements Runnable {
        private BlockingQueue<String> blockingQueue;
        final Random random = new Random();

        public SynchronousQueueProducer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    // 每个一秒钟往队列中放置一个元素
                    String data = UUID.randomUUID().toString();
                    System.out.println("put: " + data);
                    blockingQueue.put(data);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class SynchronousQueueConsumer implements Runnable {
        private BlockingQueue<String> blockingQueue;

        public SynchronousQueueConsumer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                // 每2s 从队列中取数据
                try {
                    String data = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + " take:" + data);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // 一个生产者, 两个消费者。
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(new SynchronousQueueProducer(blockingQueue)).start();
        new Thread(new SynchronousQueueConsumer(blockingQueue)).start();
//        new Thread(new SynchronousQueueConsumer(blockingQueue)).start();
    }
}
