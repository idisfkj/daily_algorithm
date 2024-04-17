package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode
import java.util.LinkedList

/**
 * 637. 二叉树的层平均值
 */

/*
给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。



示例 1：



输入：root = [3,9,20,null,null,15,7]
输出：[3.00000,14.50000,11.00000]
解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
因此返回 [3, 14.5, 11] 。
示例 2:



输入：root = [3,9,20,15,7]
输出：[3.00000,14.50000,11.00000]


提示：

树中节点数量在 [1, 104] 范围内
-231 <= Node.val <= 231 - 1
 */

class AverageOfLevels {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AverageOfLevels().averageOfLevels(TreeNode(3).apply {
                left = TreeNode(9)
                right = TreeNode(20).apply {
                    left = TreeNode(15)
                    right = TreeNode(7)
                }
            }).forEach {
                println(it)
            }
            AverageOfLevels().averageOfLevels(TreeNode(2147483647).apply {
                left = TreeNode(2147483647)
                right = TreeNode(2147483647)
            }).forEach {
                println(it)
            }
        }
    }

    /**
     * O(n)
     * O(n)
     */
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val result = arrayListOf<Double>()
        if (root == null) return result.toDoubleArray()
        val deque = LinkedList<TreeNode>()
        deque.offer(root)

        while (deque.isNotEmpty()) {
            val size = deque.size
            var total = 0L
            var i = size
            while (i-- > 0) {
                val curr = deque.poll()
                total += curr?.`val` ?: 0
                curr.left?.let { deque.offer(it) }
                curr.right?.let { deque.offer(it) }
            }
            result.add(total / size.toDouble())
        }
        return result.toDoubleArray()
    }

}