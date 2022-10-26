package com.daily.algothrim.leetcode.easy

/**
 * 145. 二叉树的后序遍历
 */
class PostorderTraversal {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PostorderTraversal().postorderTraversal(TreeNode(1).apply {
                right = TreeNode(2).apply {
                    left = TreeNode(3)
                }
            }).forEach {
                print(it)
            }
            println()
            PostorderTraversal().postorderTraversal(TreeNode(1).apply {
                right = TreeNode(2)
            }).forEach {
                print(it)
            }
            println()
        }
    }

    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        postorder(root, result)
        return result
    }

    private fun postorder(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return
        postorder(root.left, list)
        postorder(root.right, list)
        list.add(root.`val`)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}