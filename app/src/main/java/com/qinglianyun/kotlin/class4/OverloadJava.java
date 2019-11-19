package com.qinglianyun.kotlin.class4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzg on 2019/11/19.
 * function:{@link com.qinglianyun.kotlin.class3.JavaA}
 */
public class OverloadJava {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(7);
        list.add(29);
        list.add(5);
        list.remove(1);
        list.remove(5);//这种就不是好的重载 因为他不知道是remove(int index)还是remove(Object o)
        Overloads overloads = new Overloads();
        overloads.a();//加上@JvmOverloads
    }
}
