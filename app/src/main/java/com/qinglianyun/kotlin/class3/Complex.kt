package com.qinglianyun.kotlin.class3

/**
 * Created by gzg on 2019/11/15.
 * function:自定义加法规则 运算符
 */
class Complex(var real: Double, var imaginary: Double) {

    operator fun plus(other: Complex): Complex {
        return Complex(real + other.real, imaginary + other.imaginary)
    }

    operator fun plus(other: Int): Complex {
        return Complex(real + other, imaginary + other)
    }

    operator fun plus(other: Any): Int {
        return real.toInt()
    }

    override fun toString(): String {
        return "$real +${imaginary}i"
    }
}


class Book {
    infix fun on(any: Any): Boolean {
        return false
    }
}

class Desk

fun main(args: Array<String>) {
    val c1 = Complex(2.0, 3.5)
    val c2 = Complex(4.0, 7.5)

    println(c1 + c2)
    println(c1 + 5)
    print(c1 + "HelloWorld")

    if ("a" in args) {// infix 中缀表达式 不可乱用 降低可读性

    }
    if (Book() on Desk()) {

    }
}

