package com.qinglianyun.kotlin.class3

import org.apache.commons.lang3.Functions

/**
 * Created by gzg on 2019/11/13.
 * function:Lambda表达式的学习
 * note：函数也是有类型的
 * 利于1:Int类型 3.0:Double 那么例如multiply_3这种也是有类型的kotlin.jvm.functions.FunctionN
 */


fun main(args: Array<String>) {

//    println(multiply_4(2, 3))
//
    for (i in args) {
        println(i)
    }
//
//    args.forEach(sum1)
//    args.forEach() { element: String -> println(element) }//如果函数的参数是lambda表达式 那么可以将这个参数移到外面去
//    args.forEach() { element -> println(element) }
//    args.forEach { element -> println(element) } //参数移动到外边去后 可以省略小括号
//    args.forEach { println(it) }//同时去掉小括号
//    args.forEach(::println)//方法引用(references)


    //当使用双重调用(比如常见的双重循环)
    run Break@/*外部标识*/{
        args.forEach Continue@/*内部标识*/{
            if (it == "d") return@Continue
            println(it)
        }

    }
    println("The End")

//    println(multiply_5.toString())

}


fun multiply_1(arg1: Int, arg2: Int): Int {//方法
    return arg1 * arg2
}

fun multiply_2(arg1: Int, arg2: Int) = arg1 * arg2//lambda

val multiply_3 = { arg1: Int, arg2: Int -> arg1 * arg2 }//lambda


val multiply_4 = { arg1: Int, arg2: Int ->
    //lambda
    println("HelloWorld multiply_4")
    println("HelloWorld multiply_4")
    println("HelloWorld multiply_4")
    arg1 * arg2//最后一行作为lambda的返回值

}
val multiply_5 = fun(arg1: Int, arg2: Int): Int {//匿名函数
    return arg1 * arg2
}
val multiply_6 = {
    //lambda
    println("HelloWorld")
}

fun printlnUsage() {//方法
    println("no return element")
}
//匿名函数+Lambda表达式
val sum1 = { it: String ->
    println(it)//方法体内容
    Unit//最后一行作为lambda的返回值 Kotlin Unit相当于Java的Void无返回值
}

