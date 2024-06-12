package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode

/**
 * 230. 二叉搜索树中第K小的元素
 */
/*
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。



示例 1：


输入：root = [3,1,4,null,2], k = 1
输出：1
示例 2：


输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3




提示：

树中的节点数为 n 。
1 <= k <= n <= 104
0 <= Node.val <= 104


进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */
class KthSmallest {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(KthSmallest().kthSmallest(TreeNode(3).apply {
                left = TreeNode(1).apply {
                    right = TreeNode(2)
                }
                right = TreeNode(4)
            }, 1))
            println(MyBest(TreeNode(3).apply {
                left = TreeNode(1).apply {
                    right = TreeNode(2)
                }
                right = TreeNode(4)
            }).kthSmallest(1))
        }
    }

    private var result: Int = 0
    private var tempK: Int = 0
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        tempK = k
        inorderTraversals(root)
        return result
    }

    /**
     * O(h+k)
     * O(n)
     */
    private fun inorderTraversals(root: TreeNode?) {
        if (root == null) return
        inorderTraversals(root.left)
        if (--tempK == 0) {
            result = root.`val`
            return
        }
        inorderTraversals(root.right)
    }

    class MyBest(private val root: TreeNode?) {
        private val map = hashMapOf<TreeNode, Int>()

        init {
            fill(root)
        }

        fun kthSmallest(k: Int): Int {
            if (root == null) return 0
            var temp = root
            while (temp != null) {
                val curr = map.getOrDefault(temp.left, 0)
                temp = if (curr < k - 1) {
                    root.right
                } else if (curr == k - 1) {
                    break
                } else {
                    root.left
                }
            }
            return temp?.`val` ?: 0
        }

        private fun fill(root: TreeNode?): Int {
            if (root == null) return 0
            val curr = fill(root.left) + fill(root.right) + 1
            map[root] = curr
            return curr
        }
    }
}