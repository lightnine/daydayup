package com.leon.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * volatile关键字, volatile不能保证原子性
 *
 * @author leon
 * @since 2019/8/3 21:57
 */
public class VolatileDemo {
    public volatile int inc = 0;

    public int increase() {
        return inc++;
    }

    /**
     * 打印当前线程信息
     * @return
     */
    public static String crunchifyGenerateThreadDump() {
        final StringBuilder dump = new StringBuilder();
        final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        final ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds(), 100);
        for (ThreadInfo threadInfo : threadInfos) {
            dump.append('"');
            dump.append(threadInfo.getThreadName());
            dump.append("\" ");
            final Thread.State state = threadInfo.getThreadState();
            dump.append("\n   java.lang.Thread.State: ");
            dump.append(state);
            final StackTraceElement[] stackTraceElements = threadInfo.getStackTrace();
            for (final StackTraceElement stackTraceElement : stackTraceElements) {
                dump.append("\n        at ");
                dump.append(stackTraceElement);
            }
            dump.append("\n\n");
        }
        return dump.toString();
    }
    public static void main(String[] args) {
        final VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatileDemo.increase();
                }
            }).start();
        }
        // idea run 模式会有一个守护线程, 在debug模式下才能运行完成
        while (Thread.activeCount() > 1) {
//            System.out.println(crunchifyGenerateThreadDump());
//            System.out.println(Thread.activeCount());
            Thread.yield();
        }
        System.out.println(volatileDemo.inc);
    }
}
