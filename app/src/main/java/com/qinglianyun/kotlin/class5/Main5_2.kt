package com.qinglianyun.kotlin.class5

/**
 * Created by gzg on 2019/11/20.
 * function:高阶函数 forEach，map，flatMap fold reduce filter takerWhile let apply with use
 */
fun main(args: Array<String>) {
    /**
     * map的用法  map是遍历一个数组遍历的过程可以对数组item进行操作(筛选、数据转换等) ,返回一个新的数据

     */
    val list = listOf(2, 8, 4, 5, 9, 7)

    val newList = ArrayList<Int>()

    //Java思想的集合转化
    list.forEach {
        val element = it * 3 + 2
        newList.add(element)
    }

    //Kotlin 写法 等价于 newList的转化
    val newList1 = list.map {
        it * 3 + 2
    }

    //上节的内容复习
    val newList2 = list.map(Int::toDouble)
    newList.forEach(::println)
    println("====================")
    newList1.forEach(::println)
    println("====================")
    newList2.forEach(::println)


    println("==========分界线==========")
    println("==========分界线==========")

    /**
     * flatmap就是把几个小的list转换到一个大的list中
     */

    val flatList = listOf(
        2..10,
        5..25,
        100..200
    )

    flatList.forEach(::println)

    //flatten()  flatMap方法中午其他操作可以用flatten()
    val flatMapList = flatList.flatMap { intRange: IntRange ->
        intRange
    }
    println("=========flatMap之后的集合=========")
    flatMapList.forEach(::println)//flatMap 将集合中嵌套集合铺平

    //重命名写法 也是最推荐写法
    val flatMapList2 = flatList.flatMap { intRange ->
        intRange.map { intElement ->
            "No.$intElement"
        }
    }
    //上面flatMapList2表达式的完整写法
    val flatMapList3 = flatList.flatMap(fun(intRange: IntRange): List<String> {
        return intRange.map(fun(intElement: Int): String {
            return "No.$intElement"
        })
    })
    //上面flatMapList2表达式的最简写法 用默认it 第一个it是flatMap返回值是个集合 第二个it是map中的元素是单个元素
    val flatMapList4 = flatList.flatMap {
        //        it.map { it1 -> println("No.$it1") }
        it.map { println("No.$it") }//会提示 让你区分参数 it前后不是一个东西
    }
    println("=========flatMap+map之后的集合=========")

    println(flatMapList2)

    println("==========分界线==========")
    println("==========分界线==========")

    /**
     *reduce求list的和、求阶乘
     */
    println("=========reduce之后的集合=========")
    //reduce求list的和 acc是累加的结果 i是每次遍历出来的元素
    val int: Int = list.reduce { acc, i -> acc + i }
    println(int)
    //0->0 1->(1*1)*1 2->(1*1)*2 3->(1*2)*3
    (0..6).map(::factorial).forEach(::println)

    println("==========fold分界线==========")
    println("==========fold分界线==========")

    /**
     *fold 是带初始值的reduce 相对更强大
     */
    println((0..6).map(::factorial).reduce { acc, i -> acc + i })//873
    println((0..6).map(::factorial).fold(100) { acc, i -> acc + i })//100+873=973
    println((0..6).map(::factorial).fold(StringBuilder())
    { acc, i -> acc.append(i).append(",") })

    println("==========joinToString分界线==========")
    println("==========joinToString分界线==========")
    /**
     * 字符串拼接 joinToString
     */
    println((0..6).joinToString("/", ".", ";"))

    println("==========filter  takeWhile  根据条件筛选分界线==========")
    println("==========filter  takeWhile  根据条件筛选分界线==========")

    /**
     * filter  takeWhile  根据条件筛选
     */

    println((0..6).map(::factorial))
    println((0..6).map(::factorial).filter { it % 2 == 1 })
    println((0..6).map(::factorial).takeWhile { it < 130 })//遇到第一个不满足条件的停止输出
}

fun factorial(n: Int): Int {
    if (n == 0) return 1
    //相当于 n=3是 1*1,(1+2)*2,(1+2+3)*3,(1+2+3+4)*4
    return (1..n).reduce { acc, i -> acc * i }
}
