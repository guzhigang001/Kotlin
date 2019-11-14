package com.qinglianyun.kotlin.class3

/**
 * Created by gzg on 2019/11/14.
 * function:
 */
class 妹子(var 性格: String, var 长相: String, var 声音: String) {
    fun 唱歌(歌曲: String) {
        println("$性格$声音 妹子唱一首歌：$歌曲")
    }

    fun 跳舞(舞蹈: String) {
        println("$性格$长相 妹子跳一支舞蹈：$舞蹈")
    }
}

fun main(args: Array<String>) {
    val 妹子 = 妹子("温柔", "甜美", "动人")
    妹子.唱歌("好日子")
    妹子.跳舞("东方红")
}