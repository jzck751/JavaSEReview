package cn.jackse;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author Jack
 * @version 1.0
 * @description: TODO
 * @date 2021/10/2 17:21
 */
public class ReflectionTest {
    /**
     * 反射之前对于Person类的操作
     */
    @Test
    public void test1() {
        //1.创建Person类对象
        Person person = new Person("Tom", 18);

        //2.通过对象调用，调用其内部的属性与方法
        person.age = 128;
        System.out.println(person.toString());
        person.show();

        //在Person类的外部不可以通过其对象调用私有结构
    }

    /**
     * 反射之后
     */
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;
        //1.通过反射，创建Person类对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Jack", 28);
        Person p = (Person) obj;
        System.out.println(p.toString());

        //2.通过反射，调用对象指定的方法与属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        System.out.println("**********************************************");
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
        //通过反射，可以调用类的私有方法和私有属性
        //调用私有构造方法
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Hanmeimei");
        System.out.println(p1);

        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"中国");
        System.out.println(nation);

        //疑问1：通过直接new的方式或者反射的方式都可以调用公共的结构，开发中到底用哪个
        //建议：直接new
        //什么时候用反射：反射的特征：动态性；

        //疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
        //不矛盾：
    }

    /**
     *关于java.lang.Class类的理解
     *1.java 的执行过程
     * 程序经过javac.exe命令，会生成一个或多个字节码文件（.class结尾）,接着我们使用java.exe对某个字节码文件
     * 进行解释运行。相当于将某个字节码文件加到内存中。此过程就称为类的加载。加载到内存中的类我们成为运行时类，此时
     * 运行时类就作为Class的一个实例.
     *
     *2.Class的实例就对应着一个运行时类
     *3.加载到内存中的运行时类，会缓存一定的时间。再次时间之内，我们可以通过不同的方式来获取此运行时类
     */

    /**
     * 获取Class实例的方式（前三种方式需要掌握）
     */
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象获取
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("cn.jackse.Person");
        //clazz3 = Class.forName("java.long.String");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        //方式四：使用类的加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("cn.jackse.Person");
        System.out.println(clazz1 == clazz4);
    }

    /**
     * 类的加载过程：类的加载--->类的链接--->类的初始化
     */

    @Test
    public void test4(){
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.lang.Date";
                break;
            case 1:
                classPath = "java.sql.Date";
                break;
            case 2:
                classPath = "cn.jackse.Person";
                break;
        }

        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    /**
     * 创建一个指定类的对象
     * @param classPath 指定类的全类名
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }


}
