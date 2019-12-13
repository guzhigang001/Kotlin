package com.qinglianyun.kotlin.class1_2

/**
 * Created by gzg on 2019/11/11.
 * function:
 */


class 美女  private constructor(val 性格: String, val 长相: String, val 声音: String) {
    constructor(性格: String, 长相: String, 声音: String, 三围: String) : this(性格, 长相, 声音)
    constructor(性格: String, 长相: String) : this(性格, 长相, "动听")

}

class 帅哥(性格: String, 长相: String, 声音: String) : 人(性格, 长相, 声音) {
    init {
        println("帅哥: 性格:$性格，长相:$长相，声音:$声音")

    }


}

class Test{
    val d: Double
    val i: Int

    constructor(double: Double, int: Int) {
        d = double
        i = int
    }

    constructor(double: Double) {
        d = double
        i = 0
    }

}

open class 人(val 性格: String, val 长相: String, val 声音: String) {
    init {
        println("new 了一个${this.javaClass.simpleName}: 性格:$性格，长相:$长相，声音:$声音")

    }

    fun funA() {
        println(this.声音)
    }
}

fun main(args: Array<String>) {
    val 我喜欢的妹子: 美女 = 美女("温柔", "甜美", "动听","三围")
    val 我膜拜的汉子: 帅哥 = 帅哥("彪悍", "帅气", "浑厚")
    val test1 = Test(2.0)
    val test2 = Test(2.0, 3)
}