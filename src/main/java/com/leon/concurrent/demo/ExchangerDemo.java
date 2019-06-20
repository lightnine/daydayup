package com.leon.concurrent.demo;

import java.util.concurrent.Exchanger;

/**
 * Exchanger使用例子
 * @Author leon
 * @Date 2019/6/3 11:10
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");
        ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");
        new Thread(exchangerRunnable1).start();
        new Thread(exchangerRunnable2).start();
    }
}

class ExchangerRunnable implements Runnable {

    Exchanger exchanger = null;
    Object object = null;

    public ExchangerRunnable(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    @Override
    public void run() {
        try {
            Object previous = this.object;
            this.object = this.exchanger.exchange(this.object);
            System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}