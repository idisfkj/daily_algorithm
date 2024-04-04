package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode

/**
 * 101. 对称二叉树
 */

/*
给你一个二叉树的根节点 root ， 检查它是否轴对称。

示例 1：

输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：

输入：root = [1,2,2,null,3,null,3]
输出：false

提示：

树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100

进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */
class IsSymmetric {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(IsSymmetric().isSymmetric(TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(3)
                    right = TreeNode(4)
                }
                right = TreeNode(2).apply {
                    left = TreeNode(4)
                    right = TreeNode(3)
                }
            }))
            println(IsSymmetric().isSymmetric(TreeNode(1).apply {
                left = TreeNode(2).apply {
                    right = TreeNode(3)
                }
                right = TreeNode(2).apply {
                    right = TreeNode(3)
                }
            }))
        }
    }

    /**
     * O(n)
     * O(n)
     */
    fun isSymmetric(root: TreeNode?): Boolean {
        return isSame(root?.left, root?.right)
    }

    private fun isSame(l: TreeNode?, r: TreeNode?): Boolean {
        if (l == null && r == null) return true
        if (l == null || r == null) return false
        if (l.`val` != r.`val`) return false
        return isSame(l.left, r.right) && isSame(l.right, r.left)
    }
}