package com.leon.concurrent.synchronize;

/**
 * @Author leon
 * @Date 2019/5/11 14:53
 */
public class MyClassStatic {
    public static synchronized void add(int value) {
        System.out.print(value);
    }
}
