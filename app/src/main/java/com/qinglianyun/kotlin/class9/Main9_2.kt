package com.qinglianyun.kotlin.class9

/**
 * Created by gzg on 2019/12/9.
 * function:泛型的基本语法  给类定义泛型
 */

class ComparableD<T : Comparable<T>>(val a: T, val b: T)


fun main(args: Array<String>) {
    val comparablex1 = ComparableD(5.0, 4.0)
    val comparablex2 = ComparableD(5, 4)
}

