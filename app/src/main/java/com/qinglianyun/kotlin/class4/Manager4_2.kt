package com.qinglianyun.kotlin.class4

/**
 * Created by gzg on 2019/11/18.
 * function:By 关键字
 */
/**
 * 1.interface代理用 by关键字，可以不用复写实现的interface的方法
 */
abstract class Manager : Driver, Writer {
    override fun driver() {
    }

    override fun writer() {
    }
}

interface Driver {
    fun driver()
}

class CarDriver : Driver {
    override fun driver() {
        println("开车")
    }

}

interface Writer {
    fun writer()
}

class PPTWriter : Writer {
    override fun writer() {
        println("写PPT")
    }

}

class SeniorManager(val driver: Driver, val writer: Writer) : Driver by driver, Writer by writer {


}

/**
 * 不加by关键字那么就要实现接口的方法
 */
class SeniorManager1(val driver: Driver, val writer: Writer) : Driver, Writer {
    override fun driver() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun writer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

fun main(args: Array<String>) {
    val driver = CarDriver()
    val writer = PPTWriter()
    val seniorManager = SeniorManager(driver, writer)
    seniorManager.driver()
    seniorManager.writer()
}