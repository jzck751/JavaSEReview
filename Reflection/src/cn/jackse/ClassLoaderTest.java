package cn.jackse;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Jack
 * @version 1.0
 * @description: 了解类的加载器
 * @date 2021/10/3 10:15
 */
public class ClassLoaderTest {
    @Test
    public void test1() {
        //对于自定义类，使用系统加载器加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载的getParent()类:获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        //调用扩展类加载器的getParent():无法获取引导类加载器
        //引导类加载器主要负责加载Java的核心类库，是无法加载自定义的类的
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }

    /**
     * Properties:用来读取配置文件
     */
    @Test
    public void test2() throws IOException {

        Properties pros = new Properties();
        //此时的文件默认在当前的module下。
        //读取配置文件的方式一：
/*        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);*/

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(resourceAsStream);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println(user);
        System.out.println(password);


    }

}
