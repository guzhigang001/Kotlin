package com.qinglianyun.kotlin.class9

import com.google.gson.Gson
import com.qinglianyun.kotlin.class4.Person
import com.qinglianyun.kotlin.class8.People
import okio.ByteString
import java.io.File
import java.io.FileWriter
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * Created by gzg on 2019/12/9.
 * function:泛型的实现机制  inline和reified关键字
 * java 中的泛型是假泛型 因为java中会对泛型进行擦除(详细复习Java核心技术卷轴I)
 * 也就是当运行时会将泛型擦除 所以无法获取泛型  但是在Kotlin中可以
 *
 */

data class Student(val name: String, val age: Int)

fun main(args: Array<String>) {

    //inline关键字的作用
    //inline 修饰符影响函数本身和传给它的 lambda 表达式：所有这些都将内联到调用处。
    //内联可能导致生成的代码增加；不过如果我们使用得当（即避免内联过大函数），性能上会有所提升，尤其是在循环中的“超多态（megamorphic）”调用处。
    /**
     * inline关键字的作用是 一个方法带参数 同时这个方法中的参数是一个高阶函数(也就是Lambda表达式)
     * 那么inline可以提升性能 具体参考https://www.kotlincn.net/docs/reference/inline-functions.html Kotlin官方网址
     */
    inlineTest<String>(ReentrantLock()) { "b" }

    /**
     * 获取T的类型
     */
    testGenerics2<String>()

    /**
     * 获取泛型具体的类型的作用
     */

    val student = Student("ggxiaozhi", 18)
    Gson().toJson(student).let {
        File("student.json").writeText(it)
    }

    /**
     * 1.这样可以很方便的直接使用T类型
     * 2.可以类型推导  1和2是等价的
     */
    val studentBean: Student = Gson().fromJson(File("student.json").readText())
    val studentBean2 = Gson().fromJson<Student>(File("student.json").readText())
    needAStudent(Gson().fromJson(File("student.json").readText()))
    println(studentBean)

}

fun needAStudent(student: Student) {

}

inline fun <reified T> Gson.fromJson(json: String): T {
    return Gson().fromJson(json, T::class.java)
}

inline fun <T> inlineTest(l: Lock, b: () -> T) {
    l.lock()
    try {
        b()
    } finally {
        l.unlock()
    }
}


fun <T> testGenerics1() {
    //这句话是错误的 因为T编译器不知道他是什么类型
//    println(T::class.java)
}

/**
 * 加上reified关键字就可以打印出来他的类型了
 */
inline fun <reified T> testGenerics2() {
    println(T::class.java)
}


