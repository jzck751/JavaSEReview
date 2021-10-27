package cn.jackse.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Jack
 * @version 1.0
 * @description: TODO
 * @date 2021/10/27 7:24
 */
public class MapSrc {
    public static void main(String[] args) {

        Map map = new HashMap();


        map.put("no1", "张无忌");
        map.put("no2", "周芷若");

        System.out.println("华丽分割线");

        Set set = map.entrySet();
        for (Object obj : set) {
            //System.out.println(obj.getClass());
            //1.为了从HashMap$Node中取出k-v
            //先做一个向下转型
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }


    }
}
