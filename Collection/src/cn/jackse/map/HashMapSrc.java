package cn.jackse.map;

import java.util.HashMap;

/**
 * @author Jack
 * @version 1.0
 * @description: TODO
 * @date 2021/10/27 16:50
 */

@SuppressWarnings({"all"})
public class HashMapSrc {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("java", 10);
        hashMap.put("php", 20);
        hashMap.put("java", 20);

        System.out.println("map=" + hashMap);
    }
}
