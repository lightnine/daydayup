package com.leon.concurrent.waitNotify;

/**
 * 展示wait notify方法
 * @Author leon
 * @Date 2019/5/14 13:00
 */
class MonitorObject {

}
public class MyWaitNotify {
    MonitorObject monitorObject = new MonitorObject();
    public void doWait() {
        synchronized (monitorObject) {
            try {
                monitorObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void doNotify() {
        synchronized (monitorObject) {
            monitorObject.notify();
        }
    }
}
