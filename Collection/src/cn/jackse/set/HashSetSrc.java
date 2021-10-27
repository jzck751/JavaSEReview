package cn.jackse.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Jack
 * @version 1.0
 * @description: HashSet源码解读
 * @date 2021/10/26 7:35
 */

@SuppressWarnings({"all"})
public class HashSetSrc {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");

        System.out.println("HashSet=" + hashSet);
    }
}
