package com.daily.algothrim.leetcode

import com.daily.algothrim.tree.TreeNode
import kotlin.math.min

/**
 * 二叉树的最小绝对差(leetcode 530)
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 示例：
 *
 * 输入：
 *
 * 1
 * \
 *  3
 *  /
 * 2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 提示：
 * 树中至少有 2 个节点。
 */
class MinimumDifference {

    private var mPre = -1

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MinimumDifference().getMinimumDifference(TreeNode(5, left = TreeNode(4), right = TreeNode(7))))
        }
    }

    /**
     * O(n)
     */
    fun getMinimumDifference(root: TreeNode<Int>?): Int {
        return dfs(root, Int.MAX_VALUE)
    }

    /**
     * 中序遍历之后是一个递增的有序队列，直接比较
     */
    private fun dfs(root: TreeNode<Int>?, currentMin: Int): Int {
        if (root == null) return currentMin
        var sCurrentMin: Int
        sCurrentMin = dfs(root.left, currentMin)
        if (mPre < 0) {
            mPre = root.data
        } else {
            sCurrentMin = min(sCurrentMin, root.data - mPre)
            mPre = root.data
        }
        sCurrentMin = dfs(root.right, sCurrentMin)
        return sCurrentMin
    }
}