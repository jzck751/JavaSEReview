package cn.jackse.list;

import java.util.LinkedList;

/**
 * @author Jack
 * @version 1.0
 * @description: LinkedList增删改查案例
 * @date 2021/10/25 14:34
 */

@SuppressWarnings({"all"})
public class LinedListSrc {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 2; i++) {
            linkedList.add(i);
            linkedList.add(100);
            linkedList.add(100);
            for (Object object : linkedList) {
                System.out.println(object);
            }
            //linkedList.remove(0);
            //linkedList.remove(kk);
            linkedList.set(0, "韩顺平教育");
            System.out.println("===");
            for (Object object : linkedList) {
                System.out.println(object);
            }
            Object object = linkedList.get(0);
            System.out.println(" object=" + object);
            System.out.println(linkedList.getFirst());
            System.out.println(linkedList.getLast());


        }
    }
}
