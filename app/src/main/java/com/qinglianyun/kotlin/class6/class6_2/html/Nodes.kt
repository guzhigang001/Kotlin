package com.qinglianyun.kotlin.class6.class6_2.html

/**
 * Created by gzg on 2019/11/26.
 * function:
 */
fun html(block: Tag.() -> Unit): Tag {
    return Tag("html").apply {
        block(this)
    }
}

fun Tag.body(block: Body.() -> Unit) {
    this@body + Body().apply(block)
}

fun Tag.head(block: Head.() -> Unit) {
    this@head + Head().apply(block)
}


class StringNode(private val context: String) : Node {
    override fun render() = context
}

class Head : Tag("head")

class Body : Tag("body") {
    var id by MapDelegate(proerties)

    var `class` by MapDelegate(proerties)
}