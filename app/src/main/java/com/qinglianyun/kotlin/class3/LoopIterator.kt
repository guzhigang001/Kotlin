package com.qinglianyun.kotlin.class3

import java.lang.reflect.AnnotatedElement

/**
 * Created by gzg on 2019/11/15.
 * function:循环迭代遍历
 */

fun main(args: Array<String>) {

    for (arg in args) {
        println(arg)
    }

    for ((i, v) in args.withIndex()) {
        println("$i -> $v")
    }

    val myIntList = MyIntList()

    myIntList.add(1)
    myIntList.add(2)
    myIntList.add(3)
    for (i in myIntList) {
        println("i: $i")
    }
}

class MyIntList {
    private val list = ArrayList<Int>()
    fun add(i: Int) {
        list.add(i)
    }

    fun remove(index: Int) {
        list.remove(index)
    }

    operator fun iterator(): MyIterator {
        return MyIterator(list.iterator())
    }
}

class MyIterator(val iterator: Iterator<Int>) {

    operator fun next(): Int {
        return iterator.next()
    }

    operator fun hasNext(): Boolean {
        return iterator.hasNext()
    }
}