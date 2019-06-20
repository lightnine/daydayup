package com.leon.concurrent.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 展示fork join使用，任务没有返回结果
 * @Author leon
 * @Date 2019/6/3 16:28
 */
public class ForkJoinDemo1 {
    public static void main(String[] args) {
        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        forkJoinPool.invoke(myRecursiveAction);
    }
}

class MyRecursiveAction extends RecursiveAction {
    private long workLoad = 0;
    private static final int THRESHOLD = 16;
    public MyRecursiveAction(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
        if (this.workLoad > THRESHOLD) {
            System.out.println("开始分成小任务:" + this.workLoad);
            List<MyRecursiveAction> subTasks = new ArrayList<>();
            subTasks.addAll(createSubTasks());
            for (RecursiveAction subTask : subTasks) {
                subTask.fork();
            }
        } else {
            System.out.println("完成任务:" + this.workLoad);
        }
    }

    private List<MyRecursiveAction> createSubTasks() {
        List<MyRecursiveAction> subTasks = new ArrayList<>();
        MyRecursiveAction subTask1 = new MyRecursiveAction(this.workLoad / 2);
        MyRecursiveAction subTask2 = new MyRecursiveAction(this.workLoad / 2);
        subTasks.add(subTask1);
        subTasks.add(subTask2);
        return subTasks;
    }

}
