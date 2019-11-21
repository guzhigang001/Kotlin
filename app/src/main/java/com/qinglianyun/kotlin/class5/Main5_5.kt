package com.qinglianyun.kotlin.class5

/**
 * Created by gzg on 2019/11/21.
 * function:闭包
 *
 * note: 闭包有点像java的内部类，内部类持有外部类的引用，会导致外部类无法释放，也就是java中的内存泄漏
 *
 * 闭包：1.函数的运行环境
 *      2. 持有函数运行状态
 *      3.函数内部可以定义函数
 *      4.函数内部也可以定义类
 */


const val string = "Hello World"

fun makeFun(): () -> Unit {
    var count = 0
    return fun() {
        println(++count)
    }
}

fun fibonacci(): () -> Long {
    var first = 0L
    var second = 1L
    return fun(): Long {
        val result = second
        second += first
        first = second - first
        return result
    }
}

fun fibonacciIterable(): Iterable<Long> {
    var first = 0L
    var second = 1L
    return Iterable<Long> {
        object : LongIterator() {
            override fun hasNext() = true

            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first
                return result
            }

        }
    }


}

//fun add(x: Int) = fun(y: Int) = x + y

fun add(x: Int): (Int) -> Int {
    return fun(y: Int): Int {
        return x + y
    }
}

fun main(args: Array<String>) {
    val make = makeFun()
    make()
    make()
    make()
    make()
    make()

    println("============fibonacci==============")
    val f = fibonacci()
    println(f())
    println(f())
    println(f())
    println(f())
    println(f())

    println("============fibonacciIterable==============")

    for (i in fibonacciIterable()) {
        if (i > 100) break
        println(i)
    }

}