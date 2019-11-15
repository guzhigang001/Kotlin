package com.qinglianyun.kotlin.class3

/**
 * Created by gzg on 2019/11/15.
 * function:3-9 具名参数 变长参数 默认参数
 */

//fun main(args: Array<String>) {
fun main(vararg args: String) {
    for (arg in args) {
        println(arg)
    }

}

fun sum(): Int {
    return 0
}
