package cn.jackse.map;

import java.util.HashMap;

/**
 * @author Jack
 * @version 1.0
 * @description: 模拟HashMap触发扩容、树化情况
 * @date 2021/10/28 6:44
 */
public class MapSrc2 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        for (int i = 1; i <= 12; i++) {
            hashMap.put(new A(i), "hello");
        }

        System.out.println("hashMap=" + hashMap);
    }
}

class A {
    private int num;

    public A(int num) {
        this.num = num;
    }


    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "\nA{" +
                "num=" + num +
                '}';
    }
}
