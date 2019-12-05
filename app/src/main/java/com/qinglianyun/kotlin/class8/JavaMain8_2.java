package com.qinglianyun.kotlin.class8;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by gzg on 2019/12/4.
 * function: 在java中访问方法
 *
 * @see Main8_2Kt
 */
public class JavaMain8_2 {

    public static void main(String[] args) {
        try {
            Main8_2Kt.class.getDeclaredMethod("sayHello", Person.class)
                    .invoke(null, new Person("java_main_8_2", 10));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
