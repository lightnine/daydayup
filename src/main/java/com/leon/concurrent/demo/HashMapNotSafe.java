package com.leon.concurrent.demo;

import java.util.HashMap;

/**
 * @Author leon
 * @Date 2019/5/27 18:43
 * 演示HashMap在多线程下并不安全
 * 有时会有异常打出，这正表明了多线程下并不安全
 */
public class HashMapNotSafe {
    public static final HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 25; i++) {
                    map.put(String.valueOf(i), String.valueOf(i));
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                for (int j = 25; j < 50; j++) {
                    map.put(String.valueOf(j), String.valueOf(j));
                }
            }
        };
        t1.start();
        t2.start();
        //主线程休眠1秒钟，以便t1和t2两个线程将firstHashMap填装完毕。
        Thread.currentThread().sleep(1000);
        for (int i = 0; i < 50; i++) {
            //如果key和value不同，说明在两个线程put的过程中出现异常。
            if (!String.valueOf(i).equals(map.get(String.valueOf(i)))) {
                System.err.println(i + ":" + map.get(String.valueOf(i)));
            }
        }
    }
}
