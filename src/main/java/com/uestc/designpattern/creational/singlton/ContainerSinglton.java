package com.uestc.designpattern.creational.singlton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CLthinking
 * @date 2019/7/16 下午 04:29
 */
public class ContainerSinglton {
    private static Map<String, Object> singltonMap = new HashMap<>();

    public static void putInstance(String key, Object instance) {
        if (!singltonMap.containsKey(key)) {
            singltonMap.put(key, instance);
        }
    }

    public static Object getInstance(String key) {
        return singltonMap.get(key);
    }
}
