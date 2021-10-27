package cn.jackse.list;


/**
 * @author Jack
 * @version 1.0
 * @description: 模拟一个简单的双向链表
 * @date 2021/10/25 14:10
 */
public class LinkedList01 {
    public static void main(String[] args) {

        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node jerry = new Node("jerry");

        //连接三个节点，形成双向链表
        jack.next = tom;
        tom.next = jerry;

        jerry.pre = tom;
        tom.pre = jack;

        //双向链表的头
        Node first = jack;
        //双向链表的尾
        Node last = jerry;

        //遍历输出
        System.out.println("====从头到尾进行遍历====");
        while (true){
            if (first == null){
                //遍历结束
                System.out.println("遍历结束");
                break;
            }
            System.out.println(first);
            first = first.next;
        }

        //演示 从尾到头进行 遍历
        System.out.println("====从头到尾进行遍历====");
        while (true){
            if (last == null){
                //遍历结束
                System.out.println("遍历结束");
                break;
            }
            System.out.println(last);
            last = last.pre;
        }

        //演示双向链表添加数据
        //要求在tom和jerry之间插入"张飞"

        //1.创建一个node节点
        Node zhangfei = new Node("张飞");
        zhangfei.next = jerry;
        zhangfei.pre = tom;

        tom.next = zhangfei;
        jerry.pre = zhangfei;

        first = jack;
        System.out.println("====从头到尾进行遍历====");
        while (true){
            if (first == null){
                //遍历结束
                System.out.println("遍历结束");
                break;
            }
            System.out.println(first);
            first = first.next;
        }



    }
}

/**
 * 定义一个node对象，表示双向链表的结点
 */
class Node {
    /**
     * 真正存放数据
     */
    public Object item;

    /**
     * 下一个节点
     */
    public Node next;

    /**
     * 上一个节点
     */
    public Node pre;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node name=" + item;
    }
}

