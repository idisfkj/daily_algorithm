package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode
import kotlin.math.min

/**
 * 530. 二叉搜索树的最小绝对差
 */

/*
给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

差值是一个正数，其数值等于两值之差的绝对值。



示例 1：


输入：root = [4,2,6,1,3]
输出：1
示例 2：


输入：root = [1,0,48,null,null,12,49]
输出：1


提示：

树中节点的数目范围是 [2, 104]
0 <= Node.val <= 105
 */
class GetMinimumDifference {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(GetMinimumDifference().getMinimumDifference(TreeNode(4).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                }
                right = TreeNode(6)
            }))
        }
    }

    private var minResult = Int.MAX_VALUE
    private var pre = -1

    fun getMinimumDifference(root: TreeNode?): Int {
        inOrderTraversal(root)
        return minResult
    }

    /**
     * O(n)
     * O(n)
     */
    private fun inOrderTraversal(root: TreeNode?) {
        if (root == null) return
        inOrderTraversal(root.left)
        if (pre == -1) {
            pre = root.`val`
        } else {
            minResult = min(minResult, root.`val` - pre)
            pre = root.`val`
        }
        inOrderTraversal(root.right)
    }
}