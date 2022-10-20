package com.daily.algothrim.leetcode.easy

/**
 * 94. 二叉树的中序遍历
 */
class InorderTraversal {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            InorderTraversal().inorderTraversal(TreeNode(1).apply {
                right = TreeNode(2).apply {
                    left = TreeNode(3)
                }
            }).forEach {
                print(it)
            }
            println()
            InorderTraversal().inorderTraversal(TreeNode(1)).forEach {
                print(it)
            }
        }
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        inorder(root, list)
        return list
    }

    private fun inorder(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return
        inorder(root.left, list)
        list.add(root.`val`)
        inorder(root.right, list)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}