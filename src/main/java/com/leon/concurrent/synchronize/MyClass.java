package com.leon.concurrent.synchronize;

/**
 * @Author leon
 * @Date 2019/5/11 14:56
 */
public class MyClass {
    public void log(String msg) {
        synchronized(this) {
            System.out.println(msg);
        }
    }
    public static void func(String msg) {
        synchronized(MyClass.class) {
            System.out.print(msg);
        }
    }
}
