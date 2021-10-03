package cn.jackse.pratice;

import java.io.Serializable;

/**
 * @author Jack
 * @version 1.0
 * @description:
 * @date 2021/10/3 15:53
 */
public class Creature<T> implements Serializable {
    private char gender;
    private double weight;

    private void breath(){
        System.out.println("生物会呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }

}
