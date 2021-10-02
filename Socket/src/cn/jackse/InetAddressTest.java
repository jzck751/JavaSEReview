package cn.jackse;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Jack
 * @version 1.0
 * @description: TODO
 * @date 2021/10/1 16:32
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet1);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: TODO
     * @author Jack
     * @date 2021/10/2 8:41
     */

    /**
     *
     */
}
