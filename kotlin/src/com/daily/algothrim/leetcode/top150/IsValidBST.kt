package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode

/**
 * 98. 验证二叉搜索树
 */

/*
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左
子树
只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。


示例 1：


输入：root = [2,1,3]
输出：true
示例 2：


输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。


提示：

树中节点数目范围在[1, 104] 内
-231 <= Node.val <= 231 - 1
 */
class IsValidBST {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(IsValidBST().isValidBST(TreeNode(2).apply {
                left = TreeNode(1)
                right = TreeNode(3)
            }))
            println(IsValidBST().isValidBST(TreeNode(5).apply {
                left = TreeNode(1)
                right = TreeNode(4).apply {
                    left = TreeNode(3)
                    right = TreeNode(6)
                }
            }))
            println(IsValidBST().isValidBST(TreeNode(2).apply {
                left = TreeNode(2)
                right = TreeNode(2)
            }))
        }
    }

    private var temp: Long = Long.MIN_VALUE

    /**
     * O(n)
     * O(n)
     */
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        val left = isValidBST(root.left)
        if (root.`val` <= temp) return false
        temp = root.`val`.toLong()
        val right = isValidBST(root.right)
        return left && right
    }
}