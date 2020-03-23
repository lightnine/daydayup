package com.leon.zookeeperDemo;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author leon
 * @since 2020/3/23 22:34
 */
public class Sample1 {
    public static void main(String[] args) {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(ZkUtil.getZkUrl(), 5000, 3000, retryPolicy);
        client.start();
        System.out.println(client);
    }
}
