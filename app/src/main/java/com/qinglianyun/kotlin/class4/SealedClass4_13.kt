package com.qinglianyun.kotlin.class4

/**
 * Created by gzg on 2019/11/20.
 * function:密封类
 * note：密封类的概念。密封类与枚举的区别:前者是子类可数，后者是实例可数。
 * 密封类(Sealed Class)的子类必须和父类定义在同一个文件中，或者作为它的内部类。
 * 密封类的子类是可数，因为子类只能在父类内部或者和父类处于同一个文件，在其他地方是无法创建子类的。
 * 这个可数的定义就是有限的 一目了然知道的
 */
sealed class PlayerCmd {
    class Play(val name: String) : PlayerCmd() {
        fun playMusic() {
            println(name)
        }
    }

    abstract class Seek(val position: Int) : PlayerCmd() {
        abstract fun seek(int: Int = 0)
    }

    object Remove : PlayerCmd()//object也是类的关键字 构造方法无参数的时候使用

    object Pause : PlayerCmd()
}

fun main(args: Array<String>) {
    val playCmd = PlayerCmd.Play("我的祖国")
    playCmd.playMusic()
}

//和枚举有些相似
enum class PlayStatus {
    IDEA, START, PLAYING, PAUSE
}