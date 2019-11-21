package com.qinglianyun.kotlin.class5

/**
 * Created by gzg on 2019/11/21.
 * function:尾递归优化 (tailrec)
 * note:调用完自己之后没有任何操作的递归就是尾递归.
        尾递归优化就是在方法_上加tailrec 关键地提示编译器进行优化(将递
        归转化味迭代进行处理)
 */

data class ListNode(val value: Int, var next: ListNode? = null)

//尾递归
tailrec fun findListNode(head: ListNode?, value: Int): ListNode? {
    head ?: return null
    if (head.value == value) return head
    return findListNode(head.next, value)
}

//返回中存在 * 运算 所以是非尾递归
fun factorial(n: Long): Long {
    return n * factorial(n - 1)
}

data class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//这个也是非 尾递归
fun findTreeNode(root: TreeNode?, value: Int): TreeNode? {
    root ?: return null
    if (root.value == value) return root
    return findTreeNode(root.left, value) ?: findTreeNode(root.right, value)

}

fun main(args: Array<String>) {

    val MAX_NODE_SIZE = 100000
    val head = ListNode(0)
    var p = head
    for (i in 1..MAX_NODE_SIZE) {
        p.next = ListNode(1)
        p = p.next!!
    }

    println(findListNode(head, MAX_NODE_SIZE - 2))
}
