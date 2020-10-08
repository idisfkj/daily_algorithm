package com.daily.algothrim.tree

import kotlin.math.max

/**
 * 二叉树的最大深度(leetcode 104)
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *    3
 *   / \
 *  9  20
 * /   \
 * 15   7
 * 返回它的最大深度3 。
 */
class MaxDepth {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MaxDepth().solution(TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))))
        }
    }

    /**
     * 时间：O(n) n => 节点数
     * 空间：O(height) height => 高度
     */
    fun solution(root: TreeNode<Int>?): Int {
        if (root != null) {
            return max(solution(root.left), solution(root.right)) + 1
        }
        return 0
    }

}