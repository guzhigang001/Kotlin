package com.qinglianyun.kotlin.class4

/**
 * Created by gzg on 2019/11/19.
 * function:object 与Java最简单的单例模式相同(static代码块) 同时他也是一个类可以继承和实现接口 也可以定义方法
 */

interface Listener {
    fun start()
    fun stop()
}

abstract class Player

object MusicPlayer : Player(), Listener{
    override fun start() {

    }

    override fun stop() {
    }

    val state = 0

    fun continuePlay() {

    }
}