package com.qinglianyun.kotlin.class4

/**
 * Created by gzg on 2019/11/20.
 * function:枚举类 基本和Java中的枚举类是一样 每个枚举属性其实都是一个对象
 * 枚举类是final的 不能被继承可以有抽象方法 且定义抽象方法时，enum反编译是抽象类
 * 这些属性 java和kotlin是一致的
 */
enum class LogcatLevel(val id: Int) {

    VERBOSE(5), DEBUG(6), INFO(7), WARN(8), ERROR(9), ASSERT(10);//枚举类可以定义方法

    fun getTag(): String {
        return "$name , $id"
    }

    override fun toString(): String {
        return "$name , $ordinal"
    }
}

fun main(args: Array<String>) {
    println(LogcatLevel.VERBOSE)
    println(LogcatLevel.DEBUG)
    println(LogcatLevel.INFO)
    println(LogcatLevel.WARN)
    println(LogcatLevel.ERROR)
    println(LogcatLevel.ASSERT.id)

    println(LogcatLevel.DEBUG.ordinal)
    println(LogcatLevel.DEBUG.getTag())
    LogcatLevel.values().map(::println)
    println(LogcatLevel.valueOf("error".toUpperCase()))

    println(LogcatLevel2.ASSERT.id)
}

//仿写枚举类
class LogcatLevel2 private constructor(val id: Int) {
    companion object {
        val VERBOSE = LogcatLevel2(0)
        val DEBUG = LogcatLevel2(1)
        val INFO = LogcatLevel2(2)
        val WARN = LogcatLevel2(3)
        val ASSERT = LogcatLevel2(4)
    }
}