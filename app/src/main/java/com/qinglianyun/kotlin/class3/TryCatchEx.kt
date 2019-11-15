package com.qinglianyun.kotlin.class3

import java.lang.Exception

/**
 * Created by gzg on 2019/11/15.
 * function:
 */
fun main(args: Array<String>) {
    val c = try {
        println("--1")
        1
    } catch (e: Exception) {
        println(e.message)
        2
    } finally {
        println("--2")
        3
    }
    println(c)//先执行try中的返回值 finally会执行 但是不会作为返回值返回
}


