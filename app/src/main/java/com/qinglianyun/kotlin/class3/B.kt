package com.qinglianyun.kotlin.class3

/**
 * Created by gzg on 2019/11/14.
 * function:
 */

val str: String = "str"
val str1: String = String(charArrayOf('s', 't', 'r'))

class X
class B {
//    lateinit var a:Int //错误 不能再原始类型中使用 lateinit
//    lateinit var a:Double//error
//    lateinit var a1:Long//error
//    lateinit var a2:Float//error
//    lateinit var a3:Short//error
//    lateinit var a4:Char//error
//    lateinit var a5:Byte//error
//    lateinit var b: Boolean//error
    var a: Int = 0
        get() = field
        set(value) {
            field = value
        }
    lateinit var c: String

    lateinit var x1: X
    //    lateinit  val x2: //错误  不可以 val 类似final 定义后别虚初始化
    val x2: X by lazy {
        X()
    }
    var cc: String? = null

    fun value() {

    }
}

fun main(args: Array<String>) {

    val b = B()
    b.value()
    b.a
//    println(b.cc?.length) //每次都要加?.比较麻烦
    println(str == str1)
    println(str === str1)

}

