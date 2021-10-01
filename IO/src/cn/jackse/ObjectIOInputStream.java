package cn.jackse;

import cn.jackse.diy.Person;
import org.junit.Test;

import java.io.*;

/**
 * @author Jack
 * @version 1.0
 * @description: 对象流的使用
 * @date 2021/10/1 11:03
 * <p>
 * 1.ObjectInputStream、ObjectOutputStream
 * 2.作用：用于存储和读取基本数据或对象的处理流，他的强大之处就是可以把Java中的对象写入数据源中，也能把对象从数据源中还原回来
 * 3.要想一个Java对象是可序列化的，需要满足相应的要求。见Person.java
 */
public class ObjectIOInputStream {

    /**
     * 序列化过程：将内存中的Java对象保存到磁盘中或通过网络传输出去
     * 使用ObjectOutputStream实现
     */

    @Test
    public void testOutputStream() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("我爱北京天安门"));
            //刷新操作
            oos.flush();

            oos.writeObject(new Person("蒋住勇",20));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                //关闭流
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 反序列化过程
     * 使用ObjectInputStream实现
     */
    @Test
    public void ObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();
            String str = (String) obj;

            Person p = (Person)ois.readObject();

            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
