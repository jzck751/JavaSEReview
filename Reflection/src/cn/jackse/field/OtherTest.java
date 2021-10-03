package cn.jackse.field;

import cn.jackse.pratice.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author Jack
 * @version 1.0
 * @description: TODO
 * @date 2021/10/3 17:11
 */
public class OtherTest {

    /**
     * 获取构造器结构
     */
    @Test
    public void tes1t() {
        Class clazz = Person.class;

        //获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();

        //获取当前运行时类中声明的所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    /**
     * 获取运行时类的父类
     */
    @Test
    public void test2() {
        Class clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }
}
