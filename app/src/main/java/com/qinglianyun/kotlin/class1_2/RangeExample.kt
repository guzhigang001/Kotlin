package com.qinglianyun.kotlin.class1_2

/**
 * Created by gzg on 2019/11/12.
 * function:区间
 */


val rangeInt: IntRange=1..1024//[0,1024]
val range_exclusive:IntRange=0 until 1024//[0,1024)

fun main(args: Array<String>) {
    println(rangeInt.contains(50))
    println(rangeInt.contains(1024))
    println(1024 in rangeInt)
    println(range_exclusive.contains(1024))
    println(1024 in range_exclusive)

    
    for (i in range_exclusive){
        println(i)
    }
}