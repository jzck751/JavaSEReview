package cn.jackse.diy;

import java.io.Serializable;

/**
 * @author Jack
 * @version 1.0
 * @description: TODO
 * @date 2021/10/1 12:00
 *
 * Person类需要满足如下的要求才能序列化
 * 1.需要实现接口
 * 2.需要当前类提供一个全局常量：serialVersionUID
 * 3.除了当前类需要实现Serializable类外，还要保证其内部的所有属性也必须是可序列化的
 * 4.ObjectOutStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 */
public class Person implements Serializable {

    /**
     *序列版本号
     */
    public static final long serialVersionUID = 42324141324L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
