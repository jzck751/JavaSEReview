package cn.jackse.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Jack
 * @version 1.0
 * @description: TODO
 * @date 2021/10/28 10:19
 */
public class TreeSetDemo {
    public static void main(String[] args) {

        //1.当我们使用无参构造器，创建TreeSet时，仍然是无序的
        //2.
        //  需求1:按照字符串大小排序-->使用TreeSet 提供的一个构造器，可以传入一个比较器

        //TreeSet treeSet = new TreeSet();
        Comparator comparator;
        TreeSet treeSet = new TreeSet<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //调用String的compareTo方法，进行字符串的比较
                //从小到大排序,如果想要从大到小排序，那么将o1和o2倒过来
                return ((String) o1).compareTo(((String) o2));
            }
        });

        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("jerry");
        treeSet.add("rose");

        System.out.println("treeSet" + treeSet);

    }
}
