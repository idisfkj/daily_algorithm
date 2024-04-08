package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */

/*
给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。

示例 1:

输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
输出：[3,9,20,null,null,15,7]
示例 2:

输入：inorder = [-1], postorder = [-1]
输出：[-1]

提示:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder 和 postorder 都由 不同 的值组成
postorder 中每一个值都在 inorder 中
inorder 保证是树的中序遍历
postorder 保证是树的后序遍历
 */

class BuildTree2 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }

    private var j = 0

    /**
     * O(n)
     * O(n)
     */
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val map = hashMapOf<Int, Int>()
        for (i in inorder.indices) {
            map[inorder[i]] = i
        }
        j = postorder.size - 1
        return build(map, postorder, 0, inorder.size - 1)
    }

    private fun build(
        map: HashMap<Int, Int>,
        postorder: IntArray,
        l: Int,
        r: Int,
    ): TreeNode? {
        if (l > r) return null
        val curr = postorder[j]
        val index = map.getOrDefault(curr, -1)
        val tree = TreeNode(curr)
        j--
        tree.right = build(map, postorder, index + 1, r)
        tree.left = build(map, postorder, l, index - 1)
        return tree
    }
}