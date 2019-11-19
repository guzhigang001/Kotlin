package com.qinglianyun.kotlin.class4

/**
 * Created by gzg on 2019/11/18.
 * function:抽象类
 */

/**
 * 1. 默认的类和方法都是final，如果想要被子类继承，需要加open关键字修饰；
 * 2. 子类覆写父类方法时需要加关键字override修饰
 * 3. 用open表示父类方法有默认的实现 子类可以有super.work 用abstract表示不可以有默认实现 他是一个抽象的无实现方法
 * 4. 不止可以重写方法方法，还可以重写属性
 * 5. 内部重写是优先级高于外部传入的
 */
abstract class Person(val age: Int) {
    open fun work() {
    }
}

abstract class Person1(open val age: Int = 3) {

    abstract fun work()
}


class MaNong(age: Int) : Person(age) {
    override fun work() {
        super.work()
        println("我是码农，我在写代码")
    }
}

class Doctor(age: Int) : Person1(age) {
    override val age: Int
        get() = 6//5.传入后又重写

    override fun work() {
        println("我是医生，我给人看病")
    }
}

fun main(args: Array<String>) {
    val maNong: Person = MaNong(100)
    maNong.work()
    println(maNong.age)
    val doctor: Person1 = Doctor(10)
    doctor.work()
    doctor.age
    println(doctor.age)

}