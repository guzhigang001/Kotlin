package com.qinglianyun.kotlin.class3

/**
 * Created by gzg on 2019/11/15.
 * function:When 表达式的用法 替代switch
 */

fun main(args: Array<String>) {
    val x = 5
    when (x) {
        !in 1..100 -> println("$x is not in 100")
        in 1..100 -> println("$x is in 100 ")
        args[0].toInt() -> println("x==args[0]")
        is Int -> println("Hello is $x")
        else -> println("default case")
    }

    val mode = when {
        args[0].toInt() == 5 -> 1
        else -> 2
    }
}
