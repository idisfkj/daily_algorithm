package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode

/**
 * 236. 二叉树的最近公共祖先
 */

/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”



示例 1：


输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
示例 2：


输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出：5
解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
示例 3：

输入：root = [1,2], p = 1, q = 2
输出：1


提示：

树中节点数目在范围 [2, 105] 内。
-109 <= Node.val <= 109
所有 Node.val 互不相同 。
p != q
p 和 q 均存在于给定的二叉树中。
 */
class LowestCommonAncestor {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(LowestCommonAncestor().lowestCommonAncestor(TreeNode(3).apply {
                left = TreeNode(5).apply {
                    left = TreeNode(6)
                    right = TreeNode(2).apply {
                        left = TreeNode(7)
                        right = TreeNode(4)
                    }
                }
                right = TreeNode(1).apply {
                    left = TreeNode(0)
                    right = TreeNode(8)
                }
            }, TreeNode(5), TreeNode(1))?.`val`)
        }
    }

    private val map = hashMapOf<Int?, TreeNode?>()

    /**
     * O(n)
     * O(n)
     */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        postOrder(root)
        val list = arrayListOf<Int?>()
        var pCurr = map[p?.`val`]
        list.add(p?.`val`)
        while (pCurr != null) {
            if (pCurr.`val` == q?.`val`) return pCurr
            list.add(pCurr.`val`)
            pCurr = map[pCurr.`val`]
        }

        var qCurr = map[q?.`val`]
        while (qCurr != null) {
            if (list.contains(qCurr.`val`)) return qCurr
            qCurr = map[qCurr.`val`]
        }
        return null
    }

    private fun postOrder(root: TreeNode?) {
        if (root == null) return
        postOrder(root.left)
        postOrder(root.right)
        map[root.left?.`val`] = root
        map[root.right?.`val`] = root
    }
}