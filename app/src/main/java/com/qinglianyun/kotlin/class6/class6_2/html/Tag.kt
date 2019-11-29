package com.qinglianyun.kotlin.class6.class6_2.html

import java.lang.StringBuilder

/**
 * Created by gzg on 2019/11/26.
 * function:标签 proerties(id style 这些事属性)  children子节点<head><body>这些都事子节点
 */
open class Tag(val name: String) : Node {
    //标签子节点
    val children = ArrayList<Node>()

    //属性
    val proerties = HashMap<String, String>()

    operator fun String.invoke(value: String) {
        proerties[this] = value
    }

    operator fun String.invoke(block: Tag.() -> Unit) {
        this@Tag.children.add(Tag(this).apply(block))
    }

    operator fun String.unaryPlus(){
        children.add(StringNode(this))
    }

    operator fun plus(node: Node){
        children.add(node)
    }

    //<html id="htmlId" style=""><head></head> <body></body></html>
    override fun render(): String {
        return StringBuilder()
            .append("<")
            .append(name)
            .let { stringBuilder ->
                if (!this.proerties.isEmpty()) {
                    stringBuilder.append(" ")
                    this.proerties.forEach {
                        stringBuilder.append(it.key)
                            .append("=\"")
                            .append(it.value)
                            .append("\" ")
                    }
                }
                stringBuilder
            }
            .append(">")
            .let { stringBuilder ->
                children.map(Node::render).map(stringBuilder::append)
                stringBuilder
            }
            .append("</$name>")
            .toString()
    }
}