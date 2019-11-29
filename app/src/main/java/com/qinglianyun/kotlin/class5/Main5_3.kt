package com.qinglianyun.kotlin.class5

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by gzg on 2019/11/20.
 * function:let apply with 高阶函数
 *
 * let相当于将参数中的相同条件提取到外面 并且有返回值
 * apply 相当于在对象中 可以直接调用属性和方法
 * with apply作用相似 但是有参数不能null 且参数不同返回值不同
 * use 是一个自带关闭close的函数
 */

fun main(args: Array<String>) {
    val person = findPerson()

    println(person?.name)
    println(person?.age)

    //let
    println(person?.let { person ->
        println(person.name)
        println(person.age)

    })

    //let data class写法
    val let = person?.let { (name, age) ->
        println(name)
        println(age)
    }

    println(let)

    person?.let {
        it.work()
        println(it.age)
        println(it.name)
    }
    person?.apply {
        work()
        println(age)
        println(name)
    }

    //with与apply很像 但是参数不同 对象T 也不能为空 返回值也不用
    /*with(findPerson()) {
        work()
        println(age)
        println(name)
    }*/

    val br = BufferedReader(FileReader("hello.txt"))
    with(br) {
        var line: String?
        while (true) {
            line = br.readLine() ?: break
            println(line)
        }
        close()
    }
    val br1 = BufferedReader(FileReader("hello.txt")).readText()
    println("br1: $br1")

    BufferedReader(FileReader("hello.txt")).use {
        var line: String?
        while (true) {
            line = it.readLine() ?: break
            println(line)
        }
    }

}


data class Person(val name: String, val age: Int) {
    fun work() {
        println(name)
    }
}

fun findPerson(): Person? {
    return null
}

