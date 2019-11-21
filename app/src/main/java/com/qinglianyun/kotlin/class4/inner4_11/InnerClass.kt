package com.qinglianyun.kotlin.class4.inner4_11

/**
 * Created by gzg on 2019/11/20.
 * function:内部类 this@Outter this@Inner
 * note:1.内部类定义时如果没有用inner修饰的话就是静态内部类,用inner修饰后是非静态内部类
 * 匿名内部类:
 * 1.没有定义名字的内部类
 * 2.类名编译时生成,类似0utter$1. class .
 * 3.可继承父类，实现多个接口，与Java注意区别.
 *
 * kotlin内部类与java 内部类的区别
 * 1. java的内部类可以直接访问外部类的成员, kotlin的内部类不能直接访问外部类的成员,
 * 必须用inner标记之后才能访问外部类的成员(非静态内部类持有外部类的应用，而静态内部
 * 类无法持有外部类的引用，这是因为静态内部类优先于非实例对象而存在)
 *
 * 内部类和静态内部类的区别：
 * 是否持有外部类的状态(也就是非静态内部类中可以调用 外部类.this.属性/方法 静态内部类做不到)
 * 匿名内部类和内部类的区别：
 * 内部类没有定义名字直接new出来 但是在编译后也是有的类似0utter$1. class .
 *
 * 与Java的对比
 * @see InnerClassJava
 *  还有关于内部类的访问控制 public protected private 等
 */
class Outter {
    val a = 0

    class Inner {
        fun main(args: Array<String>) {
//            println(a)//访问不到 说明kotlin中默认是使用静态static内部类的
            println(Outter().a)
        }
    }

    inner class Inner1 {
        //inner关键字 变成非静态 这样就可以访问到外部类的属性的
        val a = 6

        fun main(args: Array<String>) {
//            println(a)//访问不到 说明kotlin中默认是使用静态static内部类的
            println(this@Outter.a)//当内外部类重载相同的属性或方法时 通过this@Outter访问
            println(this@Inner1.a)
            println(a)
        }
    }
}


interface OnClickListener {
    fun click()
}

class View {
    var onClickListener: OnClickListener? = null
}

open class Text

fun main(args: Array<String>) {
    val view = View()
    view.onClickListener = object : Text(), OnClickListener {
        //java 匿名内部类是不能继承的 kotlin可以
        //用object关键字来实例化内部类
        override fun click() {

        }

    }
}