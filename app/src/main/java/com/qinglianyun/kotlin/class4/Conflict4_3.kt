package com.qinglianyun.kotlin.class4

/**
 * Created by gzg on 2019/11/18.
 * function:方法签名(方法名称和返回值都相同)相同时 才需要解决方法冲突
 * 否则无解 还有接口如果有默认实现是不需要必须实现的 这点和Java不同
 *
 */
abstract class A {
    open fun x(): Int = 5
}

interface B {
    open fun x(): Int = 1
}

interface C {
    open fun x(): Int = -3
}

interface E {
    open fun x1(): String
}

class D(val y: Int) : A(), B, C {

    override fun x(): Int {
        return when {
            y >= 5 -> super<A>.x()
            y > 0 -> super<B>.x()
            else -> super<C>.x()
        }
    }
}


fun main(args: Array<String>) {
    println(D(10).x())
    println(D(3).x())
    println(D(-2).x())
}
