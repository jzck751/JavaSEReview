package cn.jackse.field;

import cn.jackse.pratice.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Jack
 * @version 1.0
 * @description: 获取运行时类的方法的结构
 * @date 2021/10/3 16:31
 */
public class MethodTest {

    @Test
    public void test1() {
        Class clazz = Person.class;

        //获取所有的方法
        //getMethods:获取当前运行时类及其所有父类中声明为public 权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //获取当前运行时类中声明的所有方法(不包含父类中声明的)
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }
    }

    /**
     * @Xxxx 权限修饰符  返回值类型  方法名（参数类型1 形参名1.。。。。） throws XxxException{}
     */
    @Test
    public void test3() {
        Class clazz = Person.class;
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            //1.获取方法声明的注解
            for (Annotation annotation : declaredMethod.getAnnotations()) {
                System.out.println(annotation);
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(declaredMethod.getModifiers()) + "\t");

            //3.返回值类型
            System.out.print(declaredMethod.getReturnType() + "\t");

            //4.方法名
            System.out.print(declaredMethod.getName() + "\t");
            System.out.print("(");

            //5.形参列表
            Class[] parameterTypes = declaredMethod.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)){
                for (Class parameterType : parameterTypes) {
                    System.out.println(parameterType.getName()+"args");
                }
            }
            System.out.println(")");

            //6.抛出的异常
            declaredMethod.getExceptionTypes();

            System.out.println();
        }

    }
}
