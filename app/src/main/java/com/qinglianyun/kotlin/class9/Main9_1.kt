package com.qinglianyun.kotlin.class9

/**
 * Created by gzg on 2019/12/5.
 * function:Kotlin中使用泛型 给方法定义泛型
 */

fun main(args: Array<String>) {

    val a = 2
    val b = 3
    println(compare(a, b))

    val comparableA=Comparablex(2.0,3.0)
    val comparableB=Comparablex(2.0,5.0)

    println(compare(comparableA,comparableB))
}

class Comparablex(val a: Double, val b: Double) : Comparable<Comparablex> {
    override fun compareTo(other: Comparablex): Int {
        return (value()-other.value()).toInt()
    }

    fun value(): Double {
        return a * a + b * b
    }

    override fun toString(): String {
        return "$a + $b i"
    }

}

fun <T : Comparable<T>> compare(a: T, b: T): T {
    return if (a > b) {
        a
    } else {
        b
    }
}
