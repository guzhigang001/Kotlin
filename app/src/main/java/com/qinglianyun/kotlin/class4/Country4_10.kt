package com.qinglianyun.kotlin.class4

import com.qinglianyun.kotlin.class4.annotations.Poko

/**
 * Created by gzg on 2019/11/19.
 * function:数据类(allOpen,noArg插件，再见 javaBean)
 * note：主要是讲解data关键字 data 主要是帮助生成copy toString componentN(对应返回定义的参数) hasCode equals等方法
 * 默认是没有无参数的构造方法 并且生成的类是final的 需要用allOpen 去掉final noArg创建无参数构造函数
 *
 *
 */
@Poko
data class Country4_10(val id: Int, val name: String)

/**
 * 自定义一个类 创建 Component方法
 */
class ComponentX {
    operator fun component1(): String {
        return "a"
    }

    operator fun component2(): String {
        return "b"
    }

    operator fun component3(): String {
        return "c"
    }

    operator fun component4(): Int {
        return 1
    }
}

fun main(args: Array<String>) {
    val china = Country4_10(0, "中国")
    println(china)
    println(china.id)
    println(china.name)
    println(china.component1())
    println(china.component2())
    val (i, n) = china
    println("i=$i")
    println("n=$n")

    val componentX = ComponentX()
    val (i1, i2, i3, i4) = componentX
    println("i1=$i1 i2=$i2 i3=$i3 i4=$i4")
}