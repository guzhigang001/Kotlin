package com.qinglianyun.kotlin.class1_2

/**
 * Created by gzg on 2019/11/12.
 * function:
 */

fun getName(): String? {
    return null
}

fun main(args: Array<String>) {

    val nameB: String? = getName()
    println(nameB?.length)//  null

    val value: String? = "HelloWorld"
    println(value!!.length)

    val nameA: String = getName() ?: return
    println(nameA.length)

    val parentA: Parent = Chlid()
    if (parentA is Chlid) {
        parentA.age
    }

    val parentB: Parent = Parent()
    val chlidA: Chlid = parentB as Chlid
    val chlidB: Chlid? = parentB as? Chlid
}

open class Parent {

}

class Chlid : Parent() {
    val age = 18
}