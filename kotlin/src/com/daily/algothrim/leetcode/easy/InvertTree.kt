package com.daily.algothrim.leetcode.easy

import java.util.LinkedList

/**
 * 226. 翻转二叉树
 */
class InvertTree {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            printlnTree(InvertTree().invertTree(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(7).apply {
                        left = TreeNode(6)
                        right = TreeNode(9)
                    }
                }
            ))
        }

        private fun printlnTree(root: TreeNode?) {
            if (root == null) return
            val queue = LinkedList<TreeNode>()
            queue.offer(root)
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                println(node.`val`)
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
        }

    }

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val left = invertTree(root.left)
        val right = invertTree(root.right)
        root.left = right
        root.right = left
        return root
    }
}