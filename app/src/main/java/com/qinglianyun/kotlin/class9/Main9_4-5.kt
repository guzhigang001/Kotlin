package com.qinglianyun.kotlin.class9

/**
 * Created by gzg on 2019/12/10.
 * function:型变
 * note：泛型参数即可作为传入的参数，也可以作为返回值，但被in和out关键字修饰后就不一样了
 * out 叫协变 只能作为返回值读取 不能写入和修改(Kotlin的list中只有get方法 没有add)
 * in 叫逆变 只能写入不能读取 只能作为参数传入 (Kotlin中的Comparable只能传入参数)
 * 不变 既没有in也没有out就叫做不变 如MutableList(相当于java中的list)
 *
 * 协变点：返回值类型是泛型类型参数
 * 逆变点：入参类型是泛型参数的类型
 * @UnsafeVariance 型变点伪例(当时协变的时候 泛型作为参数入参会报错 那么如果我们想忽略这个错误那么我就可以用这个注解标识)
 */
fun main(args: Array<String>) {


    /**
     * 协变  :泛型类型与实参的类型的继承关系相同
     *
     * 在泛型参数前面加上out表示协变，作为返回值，为只读类型，
     * 它的子类的泛型参数的类型是父类的泛型参数类型的子类，
     * 也就是说泛型参数的继承关系与类的继承关系保持一致（所以叫协变），
     * 比如Number是Int的父类  那么List<Number>也是List<Int>父类型；
     */
    val listOf: List<Number> = listOf<Int>(1, 2, 3)

    /**
     * 逆变 泛型参数的继承关系与类的继承关系相反
     *
     * 在泛型参数前面加上in表示逆变，作为传入的参数，为只写类型，
     * 它的泛型参数的继承关系与类的继承关系相反，比如父类是Any，
     * 子类是Int。
     */
    val value: Comparable<Int> = object : Comparable<Any> {
        override fun compareTo(other: Any): Int {
            return 0
        }
    }
    /**
     * 不变
     * 类型必须保持一致 泛型之间没有关系
     */
    val mutableList: MutableList<Int> = mutableListOf<Int>(1, 2, 3)


    /**
     * 星投影 （其本质就是类似Java中通配符 ？）
     * 与协变与逆变是对应的
     */

    val listOf1: List<Number> = listOf(1, 2, 3)
    //这是可以的
    val listOf2: List<*> = listOf(1, 2, 3)
//    val listOf3: List<Number> = listOf<*>(1, 2, 3)//ERROR

    //这是可以的
    val value1: Comparable<*> = object : Comparable<Any> {
        override fun compareTo(other: Any): Int {
            return 0
        }
    }
    //可以
    val value2: Comparable<*> = object : Comparable<Int> {
        override fun compareTo(other: Int): Int {
            return 0
        }
    }
    //不可以
//    val value3: Comparable<Int> = object : Comparable<*> {//error
//        override fun compareTo(other: Int): Int {
//            return 0
//        }
//    }

//    val hello=Hello<*>//ERROR 因为泛型实参时不能用*代替
    //java 是可以有弱类型的(目的是兼容1.5) Kotlin不可以 定义了泛型了 创建的时候就必须指定泛型
}

class Hello<T>

