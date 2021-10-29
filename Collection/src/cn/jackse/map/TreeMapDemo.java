package cn.jackse.map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Jack
 * @version 1.0
 * @description: TODO
 * @date 2021/10/28 10:56
 */
public class TreeMapDemo {
    public static void main(String[] args) {

        //使用默认的构造器，仍然是无序的

        /**
         * 需求：
         *  按照传入的k（String）的大小进行排序
         */

        //TreeMap treeMap = new TreeMap();
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照字符串大小比较（比的是ASCII码）
                //return ((String) o1).compareTo((String) o2);

                //按照字符串长度进行比较
                return ((String) o1).length() - ((String) o2).length();

            }
        });

        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("snow", "雪诺");
        treeMap.put("dawalisi", "达瓦里氏");

        System.out.println("treeMap= " + treeMap);
    }
}
