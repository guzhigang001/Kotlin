package com.qinglianyun.kotlin.class4

import kotlin.reflect.KProperty

/**
 * Created by gzg on 2019/11/19.
 * function:属性代理  代理的场景 比如 定义一个属性 外界去访问 可以在 getValue去读取一个文件 setValue去写入一个文件
 * 那么就相当于与读取一个就可以文件 试外部代码变得非常简洁
 *
 * 视频中还讲解了对lazy源码的理解
 */

class Delegates4_9 {
    val hello by lazy {
        //懒加载 只有第一次使用的时候才回去初始化
        "helloWorld"
    }

    val hello2 by LazyX()//代理 //不可变代理 使用2处代码
    var hello3 by LazyX()//代理

}

class LazyX {
    var value: String? = null

    //仿写Lazy   2
//    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
//        return "Hello Lazy"
//    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getValue: $thisRef ->${property.name}")
        return "Hello Lazy"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("setValue: $thisRef ->${property.name} = $value")
        this.value = value
    }
}

fun main(args: Array<String>) {
    val delegates = Delegates4_9()
    println(delegates.hello)
    println(delegates.hello2)
    println(delegates.hello3)
    delegates.hello3 = "value of hello3"
    println(delegates.hello3)
}