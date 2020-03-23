package com.leon.zookeeperDemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leon
 * @since 2020/3/23 22:38
 */
public class ZkUtil {
    public static String getZkUrl() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        String result = "";
        try {
            HashMap map = mapper.readValue(ZkUtil.class.getClassLoader().getResourceAsStream("zk.yml"), HashMap.class);
            System.out.println(map);
            Map mapZk = (Map) map.get("zk");
            result = mapZk.get("ip").toString() + ":" + mapZk.get("port");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ZkUtil.getZkUrl());
    }
}
