package cn.jackse;

/**
 * @author Jack
 * @version 1.0
 * @description: TODO
 * @date 2021/10/2 17:21
 */
public class Person {
    private String name;
    public int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
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

    public void show(){
        System.out.println("我是大大大");
    }

    private String showNation(String nation){
        System.out.println("我的国籍是："+nation);
        return nation;
    }
}
