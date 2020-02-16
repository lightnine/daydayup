package com.leon.concurrentDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 展示InheritableThreadLocal的用法
 * @author leon
 * @since 2020/2/16 10:36
 */
public class InheritableThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        InheritableThreadLocal<List<String>> inheritableThreadLocal1 = new InheritableThreadLocal<>();
        threadLocal.set("string1");
        inheritableThreadLocal.set("string2");
        List<String> list = new ArrayList<>();
        list.add("str1");
        inheritableThreadLocal1.set(list);
        System.out.println("主线程：" + Thread.currentThread() + threadLocal.get());
        System.out.println("主线程：" + Thread.currentThread() + inheritableThreadLocal.get());
        Thread sub = new Thread() {
            @Override
            public void run() {
                System.out.println("子线程：" + Thread.currentThread() + threadLocal.get());
                System.out.println("子线程：" + Thread.currentThread() + inheritableThreadLocal.get());
                inheritableThreadLocal.set("string3");
                System.out.println("子线程：" + Thread.currentThread() + inheritableThreadLocal.get());

                List<String> subList = inheritableThreadLocal1.get();
                System.out.println("子线程list:" + inheritableThreadLocal1.get());
                subList.add("str2");
                inheritableThreadLocal1.set(subList);
            }
        };
        sub.start();
        sub.join();
        System.out.println("主线程：" + Thread.currentThread() + inheritableThreadLocal.get());
        System.out.println("主线程list：" + inheritableThreadLocal1.get());
    }
}
