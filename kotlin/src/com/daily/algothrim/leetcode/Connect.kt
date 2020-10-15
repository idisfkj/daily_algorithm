package com.daily.algothrim.leetcode

import java.util.*

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 */
class Connect {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Connect().solution(Node(1,
                    Node(2,
                            Node(4), Node(5)),
                    Node(3,
                            Node(6), Node(7)
                    )
            ))?.let {
                it.printMid(it)
            }
            println()
            Connect().solutionV2(Node(1,
                    Node(2,
                            Node(4), Node(5)),
                    Node(3,
                            Node(6), Node(7)
                    )
            ))?.let {
                it.printMid(it)
            }
        }
    }

    data class Node(var data: Int, var left: Node? = null, var right: Node? = null, var next: Node? = null) {
        fun printMid(node: Node) {
            node.left?.let { printMid(it) }
            println(node.data)
            println("next:  ${node.next?.data}")
            node.right?.let { printMid(it) }
        }
    }

    /**
     * 层次遍历
     * O(n)
     */
    fun solution(root: Node?): Node? {
        if (root == null) return root
        val deque = ArrayDeque<Node>()
        val flag = Node(1)
        deque.offer(root)
        deque.offer(flag)
        while (deque.isNotEmpty()) {
            var pre: Node? = null
            var item = deque.poll()
            while (item != flag && item != null) {
                item.left?.let {
                    deque.offer(it)
                }
                item.right?.let {
                    deque.offer(it)
                }
                pre?.next = item
                pre = item
                item = deque.poll()
            }
            if (deque.isNotEmpty()) deque.offer(flag)
        }

        return root
    }

    /**
     * O(n)
     */
    fun solutionV2(root: Node?): Node? {
        if (root == null) return root
        var mostLeft = root

        while (mostLeft != null) {

            var head = mostLeft

            while (head != null) {
                // 1 同父亲相邻节点
                head.left?.next = head.right
                // 2 不同父亲相邻节点
                if (head.next != null) {
                    head.right?.next = head.next?.left
                }
                head = head.next
            }
            mostLeft = mostLeft.left
        }
        return root
    }
}