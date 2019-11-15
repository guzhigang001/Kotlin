package com.qinglianyun.kotlin.class3

/**
 * Created by gzg on 2019/11/14.
 * function:
 */

class X {

}

class B {

    //    var a:Int=0
//    lateinit var a:Int //错误 不能再原始类型中使用 lateinit
//    lateinit var a:Double
//    lateinit var a1:Long
//    lateinit var a2:Float
//    lateinit var a3:Short
//    lateinit var a4:Char
//    lateinit var a5:Byte
//    lateinit var b: Boolean
    var a: Int = 0
    lateinit var c: String

    lateinit var x1: X
    //    lateinit  val x2: //错误  不可以 val 类似final
    val x2: X by lazy {
        X()
    }


    var cc: String? = null
}

fun main(args: Array<String>) {

    val b = B()
//    println(b.cc?.length) //每次都要加?.比较麻烦
}

