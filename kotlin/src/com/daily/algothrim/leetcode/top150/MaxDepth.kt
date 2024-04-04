package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode
import kotlin.math.max

/**
 * 104. 二叉树的最大深度
 */

/*
给定一个二叉树 root ，返回其最大深度。

二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。

示例 1：

输入：root = [3,9,20,null,null,15,7]
输出：3
示例 2：

输入：root = [1,null,2]
输出：2

提示：

树中节点的数量在 [0, 104] 区间内。
-100 <= Node.val <= 100
 */

class MaxDepth {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MaxDepth().maxDepth(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                }
            ))
            println(MaxDepth().maxDepth(
                TreeNode(1).apply {
                    right = TreeNode(2)
                }
            ))
        }
    }

    /**
     * O(n)
     * O(deep)
     */
    fun maxDepth(root: TreeNode?): Int {
        return deep(root, 0)
    }

    private fun deep(node: TreeNode?, currDeep: Int): Int {
        if (node == null) return currDeep
        val left = deep(node.left, currDeep + 1)
        val right = deep(node.right, currDeep + 1)
        return max(left, right)
    }
}