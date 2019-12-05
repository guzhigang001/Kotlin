package com.qinglianyun.kotlin.class8

import com.qinglianyun.kotlin.class4.annotations.Poko
import com.qinglianyun.kotlin.class4.annotations.Poko2
import com.qinglianyun.kotlin.class4.annotations.Poko5
import kotlin.math.cos
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.*

/**
 * Created by gzg on 2019/12/4.
 * function:使用Kotlin库 使用kotlin方法在kotlin中使用注解
 * note：反射库的注意事项：
 * 1. 反射库大小的2.5M 编译ReleaseApk+混淆后会多出400多kb
 * 2. 不支持build-in Kotlin types类型反射 (内置类型：List Map String （int可以）)  //TODO 已经支持了
 * 3. 比java反射慢很多 慢12548倍 创建对象的时候  官网上已经有人反馈//TODO 已经差6-8倍了
 */

@Poko //生成无参数构造器
data class People(val name: String, @Poko5 var age: Int)//primaryConstructor
{
    fun hello1() {
        println("hello1")
    }

    fun hello2(method: String) {
        println("hello2:   $method")
    }

    fun String.times(other: Int) {
        println("类对象中的扩展方法sayHello2")
    }
}


fun People.sayHello1() {
    println("类文件的扩展方法sayHello1")
}

class NoPrimaryConstructor {
    constructor() {
        println("not primaryConstructor, no args")
    }

    constructor(num: Int) {
        println("not primaryConstructor, have args:$num")
    }
}

fun main(args: Array<String>) {
    /**
     * kotlin 获取Class对象三种方式
     */
    val Kclazz1 = People::class//类获取
    val people = People("mark", 12)
    val Kclazz2 = people::class//对象获取
    val Kclazz3 = people.javaClass.kotlin//对象获取

    /**
     * 反射创建对象
     * primaryConstructor 对象直接设置属性的构造方法
     */
    val primaryConstructor = Kclazz2.primaryConstructor!!

    val Kpeople1 = primaryConstructor.call("k-mark-1", 18)
    println("Kpeople1: $Kpeople1")


    /**
     * 无（主构造器）
     */
    val Kpeople2 = NoPrimaryConstructor::class.primaryConstructor?.call()//无住构造器

    println("Kpeople2: $Kpeople2")//输出 null

    //正确访问
    NoPrimaryConstructor::class.constructors.first().call()
    NoPrimaryConstructor::class.constructors.last().call(2)

    /**
     * 访问类中属性
     * 只能获取全部属性集合 不支持获取某个指定的属性
     */

    Kclazz2.memberProperties.forEach(::println)

    /**
     * Kclazz2 与Kclazz3 不同
     * TODO 这部分不太明白
     */
//    Kclazz2.memberProperties.first().get(Kpeople1).let { println(it) }
    Kclazz3.memberProperties.first().get(Kpeople1).let { println(it) }

    /**
     * 修改属性的值  只有属性被定义成 var才有效
     * TODO 泛型 * 不太理解
     */

    Kclazz3.memberProperties.forEach(::println)

    (Kclazz3.memberProperties.first {
        it.name == "age"
    } as? KMutableProperty1<People, Int>)?.set(Kpeople1, 11)

    println("KMutableProperty1 Kclazz3:  $Kpeople1")
    (Kclazz2.memberProperties.first {
        it.name == "age"
    }as? KMutableProperty1<People, Int>)?.set(Kpeople1, 13)
    println("KMutableProperty1 Kclazz2:  $Kpeople1")

    /**
     * 反射方法
     */

    Kclazz3.memberFunctions.forEach {
        println("function: $it")
    }

    Kclazz3.memberFunctions.forEach {
        println("name: ${it.name}")
        if (it.name == "hello2") {
            it.call(people, "你好!!!")
        }
    }

    /**
     * 访问扩展方法
     * 注意：Kotlin只能访问对象中的扩展方法 而不能访问类文件的扩展方法
     * 如：只能访问到sayHello2 访问不到sayHello1 目前也不支持访问sayHello1
     */
    Kclazz3.memberExtensionFunctions.forEach(::println)

    Kclazz3.memberExtensionFunctions.forEach {
        println(it.name)
    }

    /**
     * 无法反射包级函数  以为本身就能调用到
     * minOf()
     */

    /**
     * 访问注解 @Target(AnnotationTarget.PROPERTY)修饰才能调用 .memberProperties方法获取否则获取不到
     */
    Kclazz3.annotations.forEach(::println)//访问类的注解
    Kclazz3.memberProperties.first {
        it.name == "age"
    }.annotations.forEach {
        println("annotations: $it")
    }

    /**
     * 成员
     */

    Kclazz3.members.forEach(::println)
    String::class.members.forEach(::println)//视频中 会报错  现在已经不会报错了
    Map::class.members.forEach(::println)//视频中 会报错  现在已经不会报错了
    List::class.members.forEach(::println)//视频中 会报错  现在已经不会报错了

    /**
     * 反射调用时间对比
     */
    val Kclazz4 = people::class.java
    cost("Java 反射构造方法") {
        Kclazz4.getConstructor(String::class.java, Int::class.java).newInstance("pack", 15)
    }
    cost("Kotlin 反射构造方法") {
        primaryConstructor.call("k-mark-1", 18)
    }
}

inline fun <T> cost(tag: String = "", crossinline block: () -> T): T {
    val startTime = System.nanoTime()
    val t = block()
    println(tag + ":" + (System.nanoTime() - startTime))
    return t
}