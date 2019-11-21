package com.qinglianyun.kotlin.class5

/**
 * Created by gzg on 2019/11/20.
 * function:高级函数的基本概念
 */
fun main(args: Array<String>) {
    args.forEach(::println)//包级别函数 ::方法名

    val helloWord = Hello::printlnx//成员方法 ::方法名

    args.filter(String::isNotEmpty)//成员方法 ::方法名

    val pdfPrintln=PDFPrintln()

    args.forEach(pdfPrintln::println)

//    args.forEach(PDFPrintln::println)//原因在问答上
}

class PDFPrintln {
    fun println(any: Any?) {
        kotlin.io.println(any)
    }
}

class Hello {
    fun printlnx(message: Any?) {
        println(message)
    }
}