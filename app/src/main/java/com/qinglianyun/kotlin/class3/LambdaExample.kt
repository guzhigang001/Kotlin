package com.qinglianyun.kotlin.class3

/**
 * Created by gzg on 2019/11/13.
 * function:Lambda表达式的学习
 */


fun main(args: Array<String>) {

//    println(multiply_4(2, 3))
//
//    for (i in args) {
//        println(i)
//    }
//
//    args.forEach { element: String -> println(element) }
//    args.forEach { element -> println(element) }
//    args.forEach() { println(it) }//如果函数的参数是lambda表达式 那么可以将这个参数移到外面去
//    args.forEach { println(it) }//同时去掉小括号
//    args.forEach(::println)


//    run Break@{
//        args.forEach Continue@{
//            if (it == "d") return@Break
//            println(it)
//        }
//    }
//    println("The End")

    println(multiply_5.toString())

}


fun multiply_1(arg1: Int, arg2: Int): Int {
    return arg1 * arg2
}

fun multiply_2(arg1: Int, arg2: Int) = arg1 * arg2

val multiply_3 = { arg1: Int, arg2: Int -> arg1 * arg2 }


val multiply_4 = { arg1: Int, arg2: Int ->
    println("HelloWorld multiply_4")
    println("HelloWorld multiply_4")
    println("HelloWorld multiply_4")
    arg1 * arg2//最后一行作为lambda的返回值

}
val multiply_5 = fun(arg1: Int, arg2: Int): Int {
    return arg1 * arg2
}
val multiply_6 = {
    println("HelloWorld")
}

fun printlnUsage() {
    println("no return element")
}

