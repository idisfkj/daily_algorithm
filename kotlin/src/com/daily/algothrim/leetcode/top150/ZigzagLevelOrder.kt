package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode
import java.util.LinkedList

/**
 * 103. 二叉树的锯齿形层序遍历
 */

/*
给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。



示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：[[3],[20,9],[15,7]]
示例 2：

输入：root = [1]
输出：[[1]]
示例 3：

输入：root = []
输出：[]


提示：

树中节点数目在范围 [0, 2000] 内
-100 <= Node.val <= 100
 */
class ZigzagLevelOrder {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ZigzagLevelOrder().zigzagLevelOrder(TreeNode(3).apply {
                left = TreeNode(9)
                right = TreeNode(20).apply {
                    left = TreeNode(15)
                    right = TreeNode(7)
                }
            }).forEach {
                it.forEach { i ->
                    print("$i,")
                }
                println()
            }
        }
    }

    /**
     * O(n)
     * O(n)
     */
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return arrayListOf()
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var sign = 1
        val result = ArrayList<List<Int>>()
        while (queue.isNotEmpty()) {
            var size = queue.size
            val deque = LinkedList<Int>()
            while (size-- > 0) {
                val curr = queue.removeFirst()
                if (sign > 0) {
                    deque.offer(curr.`val`)
                } else {
                    deque.addFirst(curr.`val`)
                }
                curr.left?.let { queue.add(it) }
                curr.right?.let { queue.add(it) }
            }
            sign = -sign
            result.add(deque)
        }
        return result
    }
}