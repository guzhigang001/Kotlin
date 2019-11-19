package com.qinglianyun.kotlin.class4

import java.util.ArrayList

/**
 * Created by gzg on 2019/11/19.
 * function: 方法的重载与默认参数 返回值类型不能作为方法签名的一部分 只有参数列表和方法名
 *
 * 重载时如果不能用默认参数解决的重载 不是一个好的设计 例如 list.remove
 * @see OverloadJava
 *
 *
 */
class Overloads {

    /**
     * 下面两个就是方法的重载 方法名相同 参数不同 时可以的 返回值不决定是否重载
     */
//    fun a(): Int {
//        return 0
//    }
//
//    fun a(int: Int) {
//    }

    @JvmOverloads
    fun a(int: Int = 0) {//默认参数 可以参数 不传参数用默认值  这个方法java要调用 需要加上 @JvmOverloads否则必须穿参数
    }
    /**
     * 下面这个不允许
     */
//    fun a(int: Int):String{
//
//    }

}

fun main(args: Array<String>) {

    val overloads = Overloads()
    println(overloads.a(5))
    println(overloads.a())


    val list = ArrayList<Int>()
    list.add(1)
    list.add(2)
    list.add(4)
    list.add(7)
    list.add(29)
    list.add(5)
    /**
     * kotlin 对这种不好的重载进行的包装
     * index st.removeAt
     * Object list.remove
     */
    list.removeAt(1)
    list.removeAt(5)
    list.remove(5)
}



