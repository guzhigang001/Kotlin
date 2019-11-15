package com.qinglianyun.kotlin.class3

import android.text.Html

/**
 * Created by gzg on 2019/11/15.
 * function: 条件语句表达式
 */

private const val USER_NAME = "name"
private const val USER_PASSWORD = "password"

private const val ADMIN_NAME = "admin"
private const val ADMIN_PASSWORD = "admin"

private const val DEBUG = 0
private const val ADMIN = 1
fun main(args: Array<String>) {
    val mode = if (args.isNotEmpty() && args[0] == "1") {
        ADMIN
    } else {
        DEBUG
    }

    println("请输入用户名")
    val name = readLine()
    println("请输入密码")
    val password = readLine()

    if (mode == ADMIN && name == USER_NAME && password == USER_PASSWORD) {
        println("普通用户登录")
    } else if (name == ADMIN_NAME && password == ADMIN_PASSWORD) {
        println("管理员登陆")
    } else {
        println("登陆失败")
    }
}