package com.qinglianyun.kotlin.class3

/**
 * Created by gzg on 2019/11/12.
 * function:常量和方法
 */
val FINAL_HELLO_WORLD = "HelloWorld"
var helloWord: String = FINAL_HELLO_WORLD

fun main(args: Array<String>) {
//    FINAL_HELLO_WORLD="ddd"    //编译器是不允许的

//    if (args.size != 2) {
//        println(uager)
//        System.exit(0)
//    }
//    println(args[0])
//    var arg1 = args[0].toInt()
//    var arg2 = args[1].toInt()
//    println("$arg1 + $arg2 = ${sum(arg1, arg2)}")

    //不建议这么去写  这么写 是无法区分你想调用的是常量还是函数
    //这里和重载也不相同 因为val sum =fun 后面接的是无方法名的方法
    //这里默认是调用的方法  如果想调用常量方法  可以使用sum.invoke()
    println("方法函数 " + sum(args[0].toInt(), args[1].toInt()))
    println("方法函数 invoke: " + sum(args[0].toInt(), args[1].toInt()))

    println("常量" + sum.invoke(args[0].toInt(), args[1].toInt()))

}
fun sum(aInt1: Int, aInt2: Int): Int {
    return aInt1 + aInt2
}

val sum = fun(aInt1: Int, aInt2: Int): Int {
    println("$aInt1 + $aInt2 = ${sum(aInt1, aInt2)}")
    return aInt1 + aInt2
}
fun printlnUarge(): String {
    return "请输入两个数值 例: 1 2"
}

val uager = fun(): String {
    return "请输入两个数值 例: 1 2"
}

