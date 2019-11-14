package com.qinglianyun.kotlin.class1_2

/**
 * Created by gzg on 2019/11/12.
 * function:
 */

fun getName(): String? {
    return null
}

fun main(args: Array<String>) {

    val nameB = getName()
    println(nameB?.length)//  null

    val value:String ?= "HelloWorld"
    println(value!!.length)

    val nameA: String = getName()?: return
    println(nameA.length)


}