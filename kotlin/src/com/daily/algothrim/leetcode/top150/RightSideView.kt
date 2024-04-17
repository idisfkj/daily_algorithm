package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode
import java.util.ArrayDeque

/**
 * 199. 二叉树的右视图
 */

/*
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。



示例 1:



输入: [1,2,3,null,5,null,4]
输出: [1,3,4]
示例 2:

输入: [1,null,3]
输出: [1,3]
示例 3:

输入: []
输出: []


提示:

二叉树的节点个数的范围是 [0,100]
-100 <= Node.val <= 100
 */
class RightSideView {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            RightSideView().rightSideView(TreeNode(1).apply {
                left = TreeNode(2).apply {
                    right = TreeNode(5)
                }
                right = TreeNode(3).apply {
                    right = TreeNode(4)
                }
            }).forEach {
                println(it)
            }
        }
    }

    /**
     * O(n)
     * O(n)
     */
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = arrayListOf<Int>()
        if (root == null) return result
        val deque = ArrayDeque<TreeNode>()
        deque.offer(root)
        while (deque.isNotEmpty()) {
            var size = deque.size
            while (size-- > 0) {
                val curr = deque.poll()
                if (size == 0) {
                    result.add(curr.`val`)
                }
                curr.left?.let { deque.offer(it) }
                curr.right?.let { deque.offer(it) }
            }
        }
        return result
    }
}