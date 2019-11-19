package com.qinglianyun.kotlin.class4

import kotlin.math.min

/**
 * Created by gzg on 2019/11/19.
 * function:伴生对象与静态成员
 * kotlin 中时没有static 这种方法修饰的静态方法 所以要实现 类似于java中的静态属性就要用到伴生对象
 */


fun main(args: Array<String>) {

    val x = 4
    val y = 5
    val result = minOf(x, y)
    /**
     * 这时候调用伴生对象就相当于调用java静态方法 格式相同
     */
    val value = Latitude.ofDouble(3.0)
    println(Latitude.TAG)
}

/**
 * 私有的构造方法  companion伴生对象关键字
 */
class Latitude private constructor(val latitude: Double) {
    companion object {
        fun ofDouble(double: Double): Latitude {
            return Latitude(double)
        }

        @JvmStatic
        fun ofLatitude(latitude: Latitude): Latitude {
            return Latitude(latitude.latitude)
        }

        @JvmField
        val TAG = "Latitude"
    }
}
