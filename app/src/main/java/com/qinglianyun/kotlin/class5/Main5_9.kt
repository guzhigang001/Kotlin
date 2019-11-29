package com.qinglianyun.kotlin.class5

import java.io.File

/**
 * Created by gzg on 2019/11/26.
 * function:统计字符出现的个数  kotlin 中的map是2个都可以作为key的
 */
fun main(args: Array<String>) {
    val map = HashMap<Char, Int>()
    File("build.gradle").readText().toCharArray().filterNot(Char::isWhitespace).forEach {
        val count = map[it]
        if (count == null) map[it] = 1
        else map[it] = (count.plus(1))
    }

    map.forEach(::println)

    println("============================")

    //Char::isWhitespace=it.isWhitespace() it:Char
    val groupBy = File("build.gradle").readText().toCharArray().filterNot { it.isWhitespace() }
        .groupBy { it }//传入it表示用字符来进行分组 返回的map表示 key=字符 value=个数 如a,3 表示文本中a有3个
    //那么map中 key=a value=list (list.size=3 value=a)

    //to 表示一个中缀表达是 和in是一样的 表示 将A to B ->Pair(A,B) 原来是Map<A,List<A>>.map{ it.key to it.value.size }=List<Pair<A,B>>
    //map运算符 返回一个list集合
    val list = groupBy.map { it.key to it.value.size }
    println("============================")
    list.forEach(::println)
}