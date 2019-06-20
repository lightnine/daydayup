package com.leon.concurrent.demo;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author leon
 * @Date 2019/5/27 12:50
 */
public class BlockingDequeExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> deque = new LinkedBlockingDeque<>();
        deque.addFirst("1");
        deque.addLast("2");
        String two = deque.takeLast();
        String one = deque.takeFirst();
        System.out.println("one:" + one);
        System.out.println("two:" + two);
    }
}
