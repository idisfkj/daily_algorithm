package com.daily.algothrim.leetcode.easy

/**
 * 101. 对称二叉树
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

    fun isSymmetric(root: TreeNode?): Boolean {
        return check(root, root)
    }

    private fun check(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false

        return p.`val` == q.`val` && check(p.left, q.right) && check(p.right, q.left)
    }
}