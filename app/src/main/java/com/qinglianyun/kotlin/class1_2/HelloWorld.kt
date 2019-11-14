package com.qinglianyun.kotlin.class1_2

/**
 * Created by gzg on 2019/11/11.
 * function:
 */
val aBoolean: Boolean = true
val anotherBoolean: Boolean = false

val aChar: Char = '\''

class 美女(val 性格: String, val 长相: String, val 声音: String)

class 帅哥(性格: String, 长相: String, 声音: String) : 人(性格, 长相, 声音) {
    init {
        println("帅哥: 性格:$性格，长相:$长相，声音:$声音")
    }
}

open class 人(val 性格: String, val 长相: String, val 声音: String) {
    init {
        println("new 了一个${this.javaClass.simpleName}: 性格:$性格，长相:$长相，声音:$声音")
    }
}

fun main(args: Array<String>) {
    println(aChar)
    val 我喜欢的妹子: 美女 = 美女("温柔", "甜美", "动听")
    val 我膜拜的汉子: 帅哥 = 帅哥("彪悍", "帅气", "浑厚")
}