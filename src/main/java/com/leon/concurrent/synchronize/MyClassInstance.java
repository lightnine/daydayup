package com.leon.concurrent.synchronize;

/**
 * @Author leon
 * @Date 2019/5/10 19:51
 */
public class MyClassInstance {
    private int count;
    public synchronized void add(int value) {
        this.count += value;
    }
}
