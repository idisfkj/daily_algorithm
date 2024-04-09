package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode
import java.util.Stack

/**
 * 114. 二叉树展开为链表
 */

/*
给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。


示例 1：


输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [0]
输出：[0]


提示：

树中结点数在范围 [0, 2000] 内
-100 <= Node.val <= 100


进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */
class Flatten {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Flatten().flatten(TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(3)
                    right = TreeNode(4)
                }
                right = TreeNode(5).apply {
                    right = TreeNode(6)
                }
            })
        }
    }

    /**
     * O(n)
     * O(n)
     */
    fun flatten(root: TreeNode?) {
        if (root == null) return
        val stack = Stack<TreeNode>()
        stack.push(root)
        var pre: TreeNode? = null
        while (stack.isNotEmpty()) {
            val curr = stack.pop()
            pre?.left = null
            pre?.right = curr
            curr.right?.let {
                stack.push(it)
            }
            curr?.left?.let {
                stack.push(it)
            }
            pre = curr
        }
    }

    /**
     * O(n)
     * O(1)
     */
    fun flatten2(root: TreeNode?) {
        var curr = root
        while (curr != null) {
            if (curr.left != null) {
                val next = curr.left
                var proces = next
                while (proces?.right != null) {
                    proces = proces.right
                }
                proces?.right = curr.right
                curr.left = null
                curr.right = next
            }
            curr = curr.right
        }
    }
}