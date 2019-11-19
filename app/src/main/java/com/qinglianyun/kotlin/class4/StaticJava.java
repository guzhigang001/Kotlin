package com.qinglianyun.kotlin.class4;

/**
 * Created by gzg on 2019/11/19.
 * function:在java中调用 kotlin中的伴生方法  需要在在kotlin中加上注解方法
 */
public class StaticJava {

    public static void main(String[] args) {
        Latitude latitude = Latitude.Companion.ofDouble(3.0);//为加上注解之前的调用方式
        Latitude latitude1 = Latitude.ofLatitude(latitude);//加上@JvmStatic注解之后 和java中static方法的调用一致

        System.out.println(Latitude.TAG);
    }
}
