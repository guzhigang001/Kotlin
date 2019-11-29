package com.qinglianyun.kotlin.class5

/**
 * Created by gzg on 2019/11/21.
 * function:复合函数：本身不是语法上的关键字或是格式，是按照以前现有的知识，只不过在编写上有点难以理解
 * note:这个只是函数的复合 没有新的知识点  结合参考：https://blog.csdn.net/zsp765098084/article/details/91439054   https://blog.csdn.net/gaoanchen/article/details/83654184
 * f(gx)
 */
val add5 = { i: Int -> i + 5 }//g(x)

val multiplyBy2 = { i: Int -> i * 2 }//f(x)
fun main(args: Array<String>) {

    println(multiplyBy2(add5(8)))

    val add5AndMultiplyBy2 = add5 andThen multiplyBy2 //m(x)=f(g(x))  2*(8+5)=26
    println(add5AndMultiplyBy2(8))

    val add5AndMultiplyByCopy = multiplyBy2 andThen add5//m(x)=g(f(x))  2*8+5=21//前后参数类型相同可以置换位置 否则是不可以的 所以置换后的结果也是不同的
    println(add5AndMultiplyByCopy(8))

    val add5ComposeThen = add5 compose multiplyBy2
    println(add5ComposeThen(8))//m(x)=g(f(x)) 21

    val complexFunX = funFx complexFun funGxy
//    val complexFunXCopy =funGxy  complexFun funFx //这个就不可以 类型参数是要根据条件
    println(complexFunX(3, 2))//3*3+50+2=61
}


//m(x)=f(g(x))   add5  andThen multiplyBy2相当于g(x).andThen(f(g(x)))=Function1<P1, P2>.andThen(f(g(x)))
//复合函数 扩展Function1的扩展方法 infix 中缀表达式
//Function1 传入1个参数的函数 P1 接收的参数类型 P2返回的参数类型
//扩展方法andThen接收一个 一个参数的函数 他的参数 是add5的返回值 再返回最终结果
//andThen左边的函数  Function1<P1,P2> 接收一个参数P1 返回结果P2
//andThen右边的函数 function:Function1<P2,R> 参数为左边函数的返回值P2 返回结果R
//聚合的结果返回函数Function1<P1,R> 是以P1作为参数 R做为结果的函数
//相当于P1,P2 聚合 P2,R 返回 P1,R
//f(g(x))  P1相当于x P2 相当于g(x)返回值 返回的结果Function1<P1,R> R相当于f(g(x)) 的返回值
//Function1<P1,P2> 相当于g(x)
//function:Function1<P2,R> 相当于x
//
infix fun <P1, P2, R> Function1<P1, P2>.andThen(function: Function1<P2, R>): Function1<P1, R> {
    return fun(p1: P1): R {
        return function.invoke(this.invoke(p1))
    }
}

//compose左边函数接收参数P2 返回R
//compse右边函数 接收参数P1 返回P2
//返回结果函数P1,R
//相当于先执行右边返回了P1,P2  在执行P2,R函数 聚合成P1,R
//g(f(x))
//f(x).compose(g(f(x)))
infix fun <P1, P2, R> Function1<P2, R>.compose(function: Function1<P1, P2>): Function1<P1, R> {
    return fun(p1: P1): R {
        return this.invoke(function.invoke(p1))
    }
}

//课外扩展  m(x,y) = f(g(x,y)
val funFx = { i: Int -> i + 2 }
val funGxy = { i: Int, j: Int -> 3 * i + 100 / j }

//m(x,y) = f(g(x,y)
infix fun <P1, P2, P3, R> Function1<P3, R>.complexFun(function: Function2<P1, P2, P3>): Function2<P1, P2, R> {
    return fun(p1: P1, p2: P2): R {
        return this.invoke(function.invoke(p1, p2))
    }
}




