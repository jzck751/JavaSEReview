package cn.jackse.set;

import java.util.HashSet;

/**
 * @author Jack
 * @version 1.0
 * @description: HashMap扩容机制
 * @date 2021/10/26 11:20
 */
@SuppressWarnings({"all"})
public class HashSetIncrement {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < 100; i++) {
            hashSet.add(i);
        }


/*        for (int i = 0; i < 12; i++) {
            hashSet.add(new A(i));
        }*/
    }
}

class A {
    private int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}
