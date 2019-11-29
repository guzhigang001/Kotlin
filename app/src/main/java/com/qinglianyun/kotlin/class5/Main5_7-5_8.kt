package com.qinglianyun.kotlin.class5

import java.io.OutputStream
import java.nio.charset.Charset

/**
 * Created by gzg on 2019/11/25.
 *
 * 5_7:
 * function:柯里化函数(就是把多个函数转话成一个一个参数传入) Currying
 * note：柯里化的意义 参考慕课网提问区 老师讲解回答-->柯里化有什么意义？   还存在反柯里化
 * 柯里化就是将具有多个参数的函数，变成多个单个参数的函数，然后链式调用。注意调用时参数的顺序不能颠倒
 *
 * 5_8:偏函数
 * function:
 * 完全可以使用默认参数+具名参数的方式来实现参数的固定。如果需要固定的参数在中间，虽然说可以通过具名参数来解决，但是很尴尬，
 * 因为必须使用一大堆具名参数。因此偏函数就诞生了。 偏函数就是一个多元函数传入了部分参数之后的得到的新的函数。
 *
 * 1. 当柯里化后的函数 如果默认函数位置在参数的前面 那么 可以直接使用偏函数 如1-2
 * 2. 如果函数的默认函数在气其他位置 那么可以使用扩展方法 FunctionN 来实现 如1-3
 *
 */

fun log1(tag: String, target: OutputStream, message: Any?) {
    target.write("[$tag] $message\n".toByteArray())
}

/**
 * 柯里化函数的含义
 */
//这是一种新的表达方式 与之前的函数表达并不相同
fun log2(tag: String) = fun(target: OutputStream) = fun(message: Any?) = target.write("[$tag] $message\n".toByteArray())

fun main(args: Array<String>) {
    // ::log1与 { tag: String, target: OutputStream, message: Any? -> log1(tag, target, message) } 是等价的 表示对函数的引用
//    { tag: String, target: OutputStream, message: Any? -> log1(tag, target, message) }.curried()("ggxiaozhi")(System.out)("Hello World!")
    log1("ggxiaozhi", System.out, "Hello World!")
    log2("ggxiaozhi")(System.out)("Hello World!!")
    //一个函数的参数复合柯里化版本 那么就可以使用::方法名字 如：::log1 拿到引用使用.curried()方法
    ::log1.curried()("ggxiaozhi")(System.out)("Hello World!!!")


    //偏函数  1-2
    val consoleLogWithTag = (::log1.curried())("ggxiaozhi")(System.out)
    consoleLogWithTag("Hello World Tag")//偏函数

    //partial2
    val bytes = "我是中国人".toByteArray(charset("GBK"))
    val stringFormGBK = makeStringFromGBKBytes(bytes)
    println(stringFormGBK)

    //partial1
    val stringFormGBKP1=makeStringFromGBKBytesp1(charset("GBK"))
    println(stringFormGBKP1)
}

//kotlin中柯里化链式调用的含义
fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = this(p1, p2, p3)


val makeString = fun(byteArrays: ByteArray, charset: Charset): String {
    return String(byteArrays, charset)
}

val makeStringFromGBKBytes = makeString.partial2()(charset("GBK"))
val makeStringFromGBKBytesp1 = makeString.partial1()("我是中国人".toByteArray())

//偏函数  1-3
fun <P1, P2, R> Function2<P1, P2, R>.partial2() = fun(p2: P2) = fun(p1: P1) = this(p1, p2)//第一个参数默认 传入第二个参数

fun <P1, P2, R> Function2<P1, P2, R>.partial1() = fun(p1: P1) = fun(p2: P2) = this(p1, p2)//第二个参数默认 传入第一个