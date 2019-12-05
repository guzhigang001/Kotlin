package com.qinglianyun.kotlin.class8

import com.qinglianyun.kotlin.class4.annotations.Poko
import kotlin.jvm.*

/**
 * Created by gzg on 2019/12/4.
 * function:kotlin 中使用java方法调用反射
 * note: 其实 kotlin的访问就是对生成的字节码访问 (生成的字节码文件会多出很多方法 如copy()等)
 */
@Poko
data class Person(val name: String, val age: Int)

class DefaultConstructor

fun main(args: Array<String>) {

    val person = Person("jack", 12)

    val clazz1 = person::javaClass
    val clazz2 = person::class.java
    val person2 = clazz1.get().newInstance()
    println(person2)
    val defCons = DefaultConstructor::class.java.newInstance()
    println(defCons)
    val person3 = clazz2.getConstructor(String::class.java, Int::class.java).newInstance("pack", 15)
    println(person3)

//    val name1=clazz2.getDeclaredField("name").get(person3)//直接调用会报错 也为name是private的 无法访问 需要加上isAccessible=true
    val name2 = clazz2.getDeclaredField("name").apply { isAccessible = true }.get(person3)
    println(name2)
    val person4 =clazz2.getDeclaredMethod("copy",String::class.java,Int::class.java).invoke(person3,"pack_copy",18)
    println(person4)

   clazz2.getDeclaredField("name").apply { isAccessible = true }.set(person3,"rose")//修改参数
    println(person3)


}