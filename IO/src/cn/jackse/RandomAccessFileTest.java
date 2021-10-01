package cn.jackse;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Jack
 * @version 1.0
 * @description: TODO
 * @date 2021/10/1 15:18
 * <p>
 * 1.RandomAccessFile直接继承于Object类，实现了DataInput和DataOutput接口
 * 2.其既可以作为一个输入流，也可以作为一个输出流
 */
public class RandomAccessFileTest {

    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("object.dat"), "r");
            raf2 = new RandomAccessFile(new File("object1.dat"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * @description: TODO
     * @author Jack
     * @date 2021/10/1 15:38
     * <p>
     * RandomAccessFile作为输出流时，如果本文件不存在，则创建；如果本文件已经存在，则覆盖
     */
    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello1.txt", "rw");
        //将指针调到角标为3的位置
        raf1.seek(3);
        //write有覆盖的效果
        raf1.write("xyz".getBytes());
        raf1.close();
    }

    /**
     * @description: 使用RandomAccessFile实现插入数据的效果
     * @author Jack
     * @date 2021/10/1 15:47
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello1.txt", "rw");
        //将指针调到角标为3的位置
        raf1.seek(3);
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1){
            builder.append(new String(buffer,0,len));
        }
        //调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        //将String Builder中的数据重新写入
        raf1.write(builder.toString().getBytes());
    }




}
