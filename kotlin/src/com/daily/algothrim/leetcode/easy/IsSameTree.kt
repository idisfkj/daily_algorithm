package com.daily.algothrim.leetcode.easy

/**
 * 100. 相同的树
 */
class IsSameTree {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(IsSameTree().isSameTree(TreeNode(1).apply {
                left = TreeNode(2)
                right = TreeNode(3)
            },TreeNode(1).apply {
                left = TreeNode(2)
                right = TreeNode(3)
            }))
            println(IsSameTree().isSameTree(TreeNode(1).apply {
                left = TreeNode(2)
            },TreeNode(1).apply {
                right = TreeNode(3)
            }))
        }
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        if (p.`val` != q.`val`) return false
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}
