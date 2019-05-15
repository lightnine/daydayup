package com.leon.concurrent.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * 展示如何出现死锁
 *
 * @Author leon
 * @Date 2019/5/15 11:11
 */
public class TreeNode {
    TreeNode parent = null;
    List children = new ArrayList();

    public synchronized void addChild(TreeNode child) {
        if (!this.children.contains(child)) {
            children.add(child);
            child.setParentOnly(this);
        }
    }

    public synchronized void addChildOnly(TreeNode child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public synchronized void setParent(TreeNode parent) {
        this.parent = parent;
        parent.addChildOnly(this);
    }

    public synchronized void setParentOnly(TreeNode parent) {
        this.parent = parent;
    }

    public static void main(String[] args) {
        TreeNode parent = new TreeNode();
        TreeNode child = new TreeNode();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                parent.addChild(child);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                child.setParent(parent);
            }
        });

        thread1.start();
        thread2.start();
    }
}
