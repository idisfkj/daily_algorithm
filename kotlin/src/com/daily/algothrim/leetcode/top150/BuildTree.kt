package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.TreeNode

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */

/*
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

示例 1:

输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
示例 2:

输入: preorder = [-1], inorder = [-1]
输出: [-1]

提示:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder 和 inorder 均 无重复 元素
inorder 均出现在 preorder
preorder 保证 为二叉树的前序遍历序列
inorder 保证 为二叉树的中序遍历序列
 */
class BuildTree {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }

    /**
     * O(n)
     * O(n)
     */
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val map = hashMapOf<Int, Int>()

        for (i in inorder.indices) {
            map[inorder[i]] = i
        }

        return build(map, preorder, inorder, 0, preorder.size - 1, 0, inorder.size - 1)
    }

    private fun build(
        map: HashMap<Int, Int>,
        preorder: IntArray,
        inorder: IntArray,
        preStart: Int,
        preEnd: Int,
        inStart: Int,
        inEnd: Int
    ): TreeNode? {
        if (preStart > preEnd) return null
        val inorderIndex = map.getOrDefault(preorder[preStart], -1)
        val leftSize = inorderIndex - inStart
        val root = TreeNode(preorder[preStart])
        root.left = build(map, preorder, inorder, preStart + 1, preStart + leftSize, inStart, inorderIndex - 1)
        root.right = build(map, preorder, inorder, preStart + leftSize + 1, preEnd, inorderIndex + 1, inEnd)
        return root
    }
}