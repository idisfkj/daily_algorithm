package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode
import kotlin.math.max

/**
 * 124. 二叉树中的最大路径和
 */

/*
二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

路径和 是路径中各节点值的总和。

给你一个二叉树的根节点 root ，返回其 最大路径和 。

示例 1：

输入：root = [1,2,3]
输出：6
解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
示例 2：

输入：root = [-10,9,20,null,null,15,7]
输出：42
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42

提示：

树中节点数目范围是 [1, 3 * 104]
-1000 <= Node.val <= 1000
 */
class MaxPathSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MaxPathSum().maxPathSum(TreeNode(1).apply {
                left = TreeNode(2)
                right = TreeNode(3)
            }))
            println(MaxPathSum().maxPathSum(
                TreeNode(-10).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                }
            ))
        }
    }

    private var maxLength = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        getMax(root)
        return maxLength
    }

    /**
     * O(n)
     * O(n)
     */
    private fun getMax(root: TreeNode?): Int {
        if (root == null) return 0
        val left = max(getMax(root.left), 0)
        val right = max(getMax(root.right), 0)
        val newLength = left + right + root.`val`
        maxLength = max(maxLength, newLength)
        return root.`val` + max(left, right)
    }
}