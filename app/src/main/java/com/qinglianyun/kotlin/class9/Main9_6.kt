package com.qinglianyun.kotlin.class9

import java.lang.IllegalArgumentException
import java.lang.reflect.ParameterizedType

/**
 * Created by gzg on 2019/12/11.
 * function:利用泛型来实现MVP
 */

interface IView<out P : IPresenter<IView<P>>> {
    val presenter: P
}

interface IPresenter<out V : IView<IPresenter<V>>> {
    val view: V
}

@Suppress("UNCHECKED_CAST")
abstract class BaseView<out P : BasePresenter<BaseView<P>>> : IView<P> {

    final override val presenter: P

    init {
        presenter = findPresenterClass().newInstance()
        presenter.view = this
    }


    private fun findPresenterClass(): Class<P> {

        //1.clazz其实就是当前的BaseView<P>
        var clazz: Class<*> = this.javaClass

        while (true) {
            /**
             * 什么是ParameterizedType
             * https://blog.csdn.net/JustBeauty/article/details/81116144
             */
            //2.通过这个方法直接找到 BaseView的父类 也就是IView
            //这段代码的意思是 如果clazz的父类是有泛型的 就返回的泛型的类型ParameterizedType 否则返回null
            (clazz.genericSuperclass as? ParameterizedType)?.let {

                //3.获取所有泛型类型
                it.actualTypeArguments
            }?.firstOrNull()?.//4. 获取泛型中的第一个(以为本省IView就一个泛型)
                let {
                    return it as Class<P>//5.这时候的it其实就是P的具体的类 it是MainPresenter
                } ?: kotlin.run {
                clazz = clazz.superclass ?: throw IllegalArgumentException()
            }
        }
    }


}

abstract class BasePresenter<out V : BaseView<BasePresenter<V>>> : IPresenter<V> {
    override lateinit var view: @UnsafeVariance V


}

class MainView : BaseView<MainPresenter>()

class MainPresenter : BasePresenter<MainView>()

fun main(args: Array<String>) {
    MainView().presenter.let(::println)
}