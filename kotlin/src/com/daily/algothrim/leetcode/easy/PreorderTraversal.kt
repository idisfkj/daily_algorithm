package com.daily.algothrim.leetcode.easy

/**
 * 144. 二叉树的前序遍历
 */
class PreorderTraversal {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PreorderTraversal().preorderTraversal(TreeNode(1).apply {
                right = TreeNode(2).apply {
                    left = TreeNode(3)
                }
            }).forEach {
                print(it)
            }
            println()
            PreorderTraversal().preorderTraversal(TreeNode(1).apply {
                right = TreeNode(2)
            }).forEach {
                print(it)
            }
            println()
        }
    }

    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        preorder(root, result)
        return result
    }

    private fun preorder(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return
        list.add(root.`val`)
        preorder(root.left, list)
        preorder(root.right, list)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
