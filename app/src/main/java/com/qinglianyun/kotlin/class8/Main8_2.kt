package com.qinglianyun.kotlin.class8

import com.qinglianyun.kotlin.class4.annotations.Poko
import com.qinglianyun.kotlin.class4.annotations.Poko2
import com.qinglianyun.kotlin.class4.annotations.Poko3
import com.qinglianyun.kotlin.class4.annotations.Poko4

/**
 * Created by gzg on 2019/12/4.
 * function:使用java方法在kotlin中获取反射注解 在kotlin中访问方法  注解的访问(访问类的注解，访问成员变量的注解)
 *
 * note:getAnnotation() 通常获取注解的方法 返回一个注解
 * getAnnotationsByType() 访问相同注解重复使用
 *
 * 当注解被@Retention(AnnotationRetention.BINARY)修饰时无法获取到注解
 * @see AnnotationRetention
 * 属性 SOURCE BINARY RUNTIME 只有当RUNTIME可以获取到注解(不设置默认是RUNTIME)
 *
 *  @see AnnotationTarget 默认是class(当不设置的时候) 如果注解参数用 FIELD 其他参考AnnotationTarget定义
 * 注解分作用类型
 * 同时注解
 * @see @JvmField
 * @see JavaMain8_2
 *
 *
 */


@Poko
class AnnotationTest1(val name: String = "name1")

@Poko
@Poko2
class AnnotationTest2(val name: String = "name2")

class AnnotationTest3(@Poko val name: String = "name3")

class AnnotationTest4(@Poko3 @Poko4 val name: String = "name4")

fun Person.sayHello() {
    println(this.name)
}

fun sayHello() {
    println("say Hello World !!!")
}

fun main(args: Array<String>) {


    //扩展方法
    Class.forName("com.qinglianyun.kotlin.class8.Main8_2Kt")
        .getDeclaredMethod("sayHello", Person::class.java)
        .invoke(null, Person("kotlin hello", 3))

    //包级方法
    Class.forName("com.qinglianyun.kotlin.class8.Main8_2Kt")
        .getDeclaredMethod("sayHello")
        .invoke(null)
    val poko = Class.forName("com.qinglianyun.kotlin.class8.AnnotationTest1")
        .getAnnotation(Poko::class.java)
    println("AnnotationTest1:  $poko")

    //TODO 这个有问题 运行结果与理解不相符合 提问区提问了
    Class.forName("com.qinglianyun.kotlin.class8.AnnotationTest2")
        .annotations.forEach {
        println("AnnotationTest2:  $it")
    }

    Class.forName("com.qinglianyun.kotlin.class8.AnnotationTest3")
        .getDeclaredField("name").annotations.forEach {
        println("AnnotationTest3:  $it")//什么都打印不出来  因为注解分注解类型 AnnotationTarget
    }
    Class.forName("com.qinglianyun.kotlin.class8.AnnotationTest4")
        .getDeclaredField("name").annotations.forEach {
        println("AnnotationTest4:  $it")
    }
}
