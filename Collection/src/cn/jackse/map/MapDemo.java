package cn.jackse.map;


import java.util.HashMap;

/**
 * @author Jack
 * @version 1.0
 * @description: TODO
 * @date 2021/10/27 7:05
 */
public class MapDemo {
    public static void main(String[] args) {

        HashMap map = new HashMap();

        map.put("no1", "张无忌");
        map.put("no2", "周芷若");

        System.out.println("map=" + map);
    }
}
