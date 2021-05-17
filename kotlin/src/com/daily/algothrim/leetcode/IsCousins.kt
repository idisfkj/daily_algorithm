package com.daily.algothrim.leetcode

import java.util.*

/**
 * 993. 二叉树的堂兄弟节点
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 */
class IsCousins {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(IsCousins().isCousins(TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(4)
                }
                right = TreeNode(3)
            }, 4, 3))
            println(IsCousins().isCousins(TreeNode(1).apply {
                left = TreeNode(2).apply {
                    right = TreeNode(4)
                }
                right = TreeNode(3).apply {
                    right = TreeNode(5)
                }
            }, 5, 4))
        }
    }

    // 输入：root = [1,2,3,4], x = 4, y = 3
    // 输出：false

    // 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
    // 输出：true
    /**
     * O(n): n 节点数
     */
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        if (root == null) return false
        val queue = LinkedList<TreeNode>()
        val depthQueue = LinkedList<Int>()
        queue.offer(root)
        depthQueue.offer(0)
        var xParent: TreeNode? = null
        var yParent: TreeNode? = null
        var xDepth = 0
        var yDepth = 0
        var xFound = false
        var yFound = false

        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            val depth = depthQueue.poll()
            curr.left?.let {
                queue.offer(it)
                depthQueue.offer(depth + 1)
                if (it.`val` == x) {
                    xParent = curr
                    xDepth = depth + 1
                    xFound = true
                } else if (it.`val` == y) {
                    yParent = curr
                    yDepth = depth + 1
                    yFound = true
                }
            }
            curr.right?.let {
                queue.offer(it)
                depthQueue.offer(depth + 1)
                if (it.`val` == x) {
                    xParent = curr
                    xDepth = depth + 1
                    xFound = true
                } else if (it.`val` == y) {
                    yParent = curr
                    yDepth = depth + 1
                    yFound = true
                }
            }
            if (xFound && yFound) break
        }

        return xParent != yParent && xDepth == yDepth
    }
}

