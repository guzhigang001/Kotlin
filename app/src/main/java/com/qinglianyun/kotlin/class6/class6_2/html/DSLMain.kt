package com.qinglianyun.kotlin.class6.class6_2.html

/**
 * Created by gzg on 2019/11/26.
 * function:DSL html语言
 */

fun main(args: Array<String>) {
    Tag("html").apply {
        proerties["id"] = "HtmlId"
        children.add(Tag("head"))

    }.render().let(::println)

    println("===============kotlin简化版本=====================")
    html {
        "id"("htmlId")
        "head"{
            "id"("headId")
        }
        body {
            id="bodyId"
            `class`="bodyClass"
            "a"{
                "href"("https://www.kotliner.cn")
                +"Kotlin 中文博客"
            }
        }
    }.render().let(::println)
}