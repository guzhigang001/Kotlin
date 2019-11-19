package com.qinglianyun.kotlin.class3

/**
 * Created by gzg on 2019/11/19.
 * function:
 */
class A {
    //默认 是public  get set 需要与 b的修饰符一致
    var b = 0

        get() {
            println("Kotlin getter b")
            return field
        }
        set(value) {
            println("Kotlin setter b")
            field = value
        }
}

