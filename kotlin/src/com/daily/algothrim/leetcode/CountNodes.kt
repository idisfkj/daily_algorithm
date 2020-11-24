package com.daily.algothrim.leetcode

import java.util.*

/**
 * 222. 完全二叉树的节点个数
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * */
class CountNodes {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CountNodes().solution(TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(4)
                    right = TreeNode(5)
                }
                right = TreeNode(3).apply {
                    left = TreeNode(6)
                }
            }))
            println()
            println(CountNodes().solution2(TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(4)
                    right = TreeNode(5)
                }
                right = TreeNode(3).apply {
                    left = TreeNode(6)
                }
            }))
        }
    }

    fun solution(root: TreeNode?): Int {
        if (root == null) return 0

        val deque = ArrayDeque<TreeNode>()
        var count = 0
        deque.offer(root)
        while (deque.isNotEmpty()) {
            count++
            val cur = deque.poll()
            cur.left?.let {
                deque.offer(it)
            }
            cur.right?.let {
                deque.offer(it)
            }
        }

        return count
    }

    fun solution2(root: TreeNode?): Int {
        if (root == null) return 0
        val left = solution2(root.left)
        val right = solution2(root.right)
        return left + right + 1
    }

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}