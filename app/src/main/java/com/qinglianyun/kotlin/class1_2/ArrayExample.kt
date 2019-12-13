package com.qinglianyun.kotlin.class1_2

import com.qinglianyun.kotlin.class1_2.城市.北京.市委书记

/**
 * Created by gzg on 2019/11/12.
 * function:数组代码实例
 * 定义好基本类型的数组 防止装箱拆箱带来的开销
 */

val arrayInt: IntArray = intArrayOf(1, 3, 5, 7)
val arrayChar: CharArray = charArrayOf('H', 'e', 'l', 'l', 'o')
val arrayString: Array<String> = arrayOf("谷", "志", "刚")
val array书记: Array<市委书记> = arrayOf(市委书记("张"), 市委书记("李"), 市委书记("王"))

val a="xxxxxx"
var a1=a
fun main(args: Array<String>) {
    println(arrayInt.size)
    for (i in arrayInt) {
        println(i)
    }

    println(arrayChar.joinToString(""))//连接字符
    println(arrayString.joinToString(""))//连接字符串
    println(array书记[1])
    array书记[1] = 市委书记("赵")
    println(array书记[1])
    println(arrayInt.slice(1..3))//表示的是下标 slice表示"切片"
}

