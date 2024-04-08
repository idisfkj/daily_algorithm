package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.Connect.Node
import java.util.ArrayDeque

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */

/*
给定一个二叉树：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。

初始状态下，所有 next 指针都被设置为 NULL 。

示例 1：

输入：root = [1,2,3,4,5,null,7]
输出：[1,#,2,3,#,4,5,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
示例 2：

输入：root = []
输出：[]


提示：

树中的节点数在范围 [0, 6000] 内
-100 <= Node.val <= 100
进阶：

你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
 */

class Connect {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Connect().connect(Node(1).apply {
                left = Node(2).apply {
                    left = Node(4)
                    right = Node(5)
                }
                right = Node(3).apply {
                    right = Node(7)
                }
            })?.let { it.printMid(it) }
            println()
            Connect().connect2(Node(1).apply {
                left = Node(2).apply {
                    left = Node(4)
                    right = Node(5)
                }
                right = Node(3).apply {
                    right = Node(7)
                }
            })?.let { it.printMid(it) }
        }
    }

    /**
     * O(n)
     * O(n)
     */
    fun connect(root: Node?): Node? {
        if (root == null) return null
        val deque = ArrayDeque<Node>()
        deque.offer(root)
        while (deque.isNotEmpty()) {
            val size = deque.size
            var pre: Node? = null

            for (i in 0 until size) {
                val node = deque.poll()
                node.left?.let { deque.offer(it) }
                node.right?.let { deque.offer(it) }

                if (pre != null) {
                    pre.next = node
                }
                pre = node
            }
        }

        return root
    }

    /**
     * O(n
     * O(1)
     */
    fun connect2(root: Node?): Node? {
        if (root == null) return null
        var temp: Node?
        var pre: Node? = null
        var next: Node? = root
        var nextStart: Node?

        while (next != null) {
            temp = next
            nextStart = null
            while (temp != null) {
                nextStart = nextStart ?: temp.left ?: temp.right
                pre?.next = temp.left
                if (temp.left != null) {
                    pre = temp.left
                }
                pre?.next = temp.right
                if (temp.right != null) {
                    pre = temp.right
                }
                temp = temp.next
            }
            pre = null
            next = nextStart
        }

        return root
    }
}