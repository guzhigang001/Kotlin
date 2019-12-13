package com.qinglianyun.kotlin.class3

import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: gzg
 * @date: 2019/11/15
 * @funtion： 具名参数 变长参数 默认参数
 */
fun main(vararg args: String) {
//    for (arg in args) {
//        println(arg)
//    }

//    hello(1,2,3,4,"Hello")    //错误 变长参数 需要指定 否则不知道hello 会以为是args中的参数
    hello(1, 2, 3, 4, string = "Hello")//后面是具名参数 即string=
    hello(3.0, 1, 2, 3, 4, string = "Hello")//在变长参数之前是不需要具名参数的


    val array = intArrayOf(1, 2, 3, 4)
    val list = ArrayList<Int>()
    list.add(1)
    list.add(2)
    list.add(3)
    hello(*array, string = "hello")
    hello(3.0, *array, string = "hello")
    hello(args = *array, string = "hello")//不传的话 后面的参数使用具名参数
//    hello(*list,string = "hello")//list 现在还不支持* 表示
//    hello(long = *array, string = "hellow")

}

fun hello(vararg args: Int, string: String) {
    args.forEach(::println)
    println(string)
}

fun hello(double: Double, vararg args: Int, string: String) {
    args.forEach(::println)
    println(string)
}

fun hello(long: Long = 3L, vararg args: Int, string: String) {//给long设置默认值 这样不传的时候就使用默认值
    args.forEach(::println)
    println(string)
}

fun hello(list: ArrayList<Int>) {

}
