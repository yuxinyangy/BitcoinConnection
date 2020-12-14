package com.btc.rpc.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map的实例
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap();//底层的实现数据结构的哈希表
        //key==>value,key唯一,value无影响
        map.put("name","lty");
        map.put("age","18");
        map.put("sex","v");

        //遍历map:思路，map无序，无法直接遍历，只能先得到Key，然后根据key获取value
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String value = map.get(key);
            System.out.println(value);
        }
        //迭代器iterator
    }
}
