package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode

/**
 * 112. 路径总和
 */

/*
给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

叶子节点 是指没有子节点的节点。

示例 1：

输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
输出：true
解释：等于目标和的根节点到叶节点路径如上图所示。
示例 2：

输入：root = [1,2,3], targetSum = 5
输出：false
解释：树中存在两条根节点到叶子节点的路径：
(1 --> 2): 和为 3
(1 --> 3): 和为 4
不存在 sum = 5 的根节点到叶子节点的路径。
示例 3：

输入：root = [], targetSum = 0
输出：false
解释：由于树是空的，所以不存在根节点到叶子节点的路径。

提示：

树中节点的数目在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */
class HasPathSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                HasPathSum().hasPathSum(
                    TreeNode(5).apply {
                        left = TreeNode(4).apply {
                            left = TreeNode(11).apply {
                                left = TreeNode(7)
                                right = TreeNode(2)
                            }
                        }
                        right = TreeNode(8).apply {
                            left = TreeNode(13)
                            right = TreeNode(4).apply {
                                right = TreeNode(1)
                            }
                        }
                    }, 22
                )
            )
        }
    }

    /**
     * O(n)
     * O(H) H树的高度
     */
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        if (targetSum - root.`val` == 0 && root.left == null && root.right == null) return true

        return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
    }
}