package com.qinglianyun.kotlin.class4

import java.lang.StringBuilder

/**
 * Created by gzg on 2019/11/19.
 * function:扩展成员 类似于java的工具类
 * 但是java很多工具类都是需要自己二次封装成Utils Kotlin有很多已经封装好的
 */


fun main(args: Array<String>) {

    //这两个方法都是java没有的
    if (args.isNotEmpty()) {

    }

    if (args.isEmpty()) {

    }

    println("abc".copy(5))
    println("abc" * 5)//操作符 times对应* 具体参照文档 https://kotlinlang.org/docs/reference/operator-overloading.html

    println("qwe".a)
    println("qwe".b)
}

//自己定义一个扩展方法 方法的名字是  类型.方法名
fun String.copy(int: Int): String {
    val buildStr = StringBuilder()
    for (i in 0 until int) {
        buildStr.append("abc")
    }
    return buildStr.toString()

}

//也可以用操作符
operator fun String.times(int: Int): String {
    val buildStr = StringBuilder()
    for (i in 0 until int) {
        buildStr.append("abc")
    }
    return buildStr.toString()

}

val String.a: String
    get() {
//        return a + "aaaa"
        return "aaaa"
    }


var String.b: Int
    set(value) {
//        b = value //无效的 因为这个是没有定义变量的 也不建议这么去写 没什么 意义
    }
    get() {
        return 5
    }