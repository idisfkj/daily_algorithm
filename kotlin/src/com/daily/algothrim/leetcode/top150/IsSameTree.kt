package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode

/**
 * 100. 相同的树
 */

/*
给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1：

输入：p = [1,2,3], q = [1,2,3]
输出：true
示例 2：


输入：p = [1,2], q = [1,null,2]
输出：false
示例 3：


输入：p = [1,2,1], q = [1,1,2]
输出：false


提示：

两棵树上的节点数目都在范围 [0, 100] 内
-104 <= Node.val <= 104
 */

class IsSameTree {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(IsSameTree().isSameTree(TreeNode(1).apply {
                left = TreeNode(2)
                right = TreeNode(3)
            }, TreeNode(1).apply {
                left = TreeNode(2)
                right = TreeNode(3)
            }))
            println(IsSameTree().isSameTree(TreeNode(1).apply {
                left = TreeNode(2)
            }, TreeNode(1).apply {
                right = TreeNode(2)
            }))
        }
    }

    /**
     * O(min(n, m)) n,m二叉树节点数
     * O(min(n, m)) 不会超过最小二叉树的高度，最坏情况下高度等于节点数
     */
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        if (p.`val` != q.`val`) return false
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}