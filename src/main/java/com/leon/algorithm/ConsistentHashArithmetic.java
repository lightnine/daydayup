package com.leon.algorithm;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * ClassName ConsistentHashArithmetic
 * Description 使用TreeMap实现一致性hash,
 * 在生产环境中虚拟节点个数一般会选择的比较多才能达到负载均衡的目的
 * 参考：https://my.oschina.net/u/4305951/blog/4136275
 * Create by leon's melody
 * Date 2020/6/24 23:06
 */
public class ConsistentHashArithmetic {
    // 服务器列表, 要加入到一致性hash环中的服务器。当然具体代码中也加入了虚拟节点
    private static final String[] servers = {"192.168.0.0:3306", "192.168.0.1:3306", "192.168.0.2:3306",
            "192.168.0.3:3306", "192.168.0.4:3306", "192.168.0.5:3306"};
    // hash环，key是hash值，value是对应的服务器名称
    private static final SortedMap<Integer, String> virtualNodes = new TreeMap<>();
    // 每个真实物理服务器对应的五个虚拟节点
    private static final int VIRTUAL_NODES = 5;

    static {
        for (String server : servers) {
            for (int j = 0; j < VIRTUAL_NODES; j++) {
                String virtualName = server + "&Node" + j;
                int hashValue = getHashValue(virtualName);
                virtualNodes.put(hashValue, virtualName);
                System.out.println("虚拟节点[" + virtualName + "]已添加到hash环, hash值为:" + hashValue);
            }
        }
    }

    /**
     * 使用FNV1_32_HASH算法计算Hash值
     *
     * @param nodeName
     * @return
     */
    private static int getHashValue(String nodeName) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < nodeName.length(); i++)
            hash = (hash ^ nodeName.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    /**
     * 获取当前值对应的服务器
     *
     * @param splitKey
     * @return
     */
    private static String getServerNode(String splitKey) {
        int hash = getHashValue(splitKey);
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        String virtualNode;
        Integer i;
        if (subMap.isEmpty()) {
            //如果没有比该key的hash值大的，则从第一个node开始
            i = virtualNodes.firstKey();
            virtualNode = virtualNodes.get(i);
        } else {
            //第一个Key就是顺时针过去离node最近的那个结点
            i = subMap.firstKey();
            virtualNode = subMap.get(i);
        }
        if (!"".equals(virtualNode)) {
            return virtualNode.substring(0, virtualNode.indexOf("&"));
        }
        return null;
    }

    public static void main(String[] args) {
        String[] uids = {"100","199", "10000", "19999", "1000000", "1999999", "100000000",  "199999999"};
        for (String uid : uids) {
            System.out.println("[" + uid + "]的hash值为" + getHashValue(uid) + ", 被路由到结点[" + getServerNode(uid) + "]");
        }
    }
}
