package com.daily.algothrim.leetcode

/**
 * 1738. 找出第 K 大的异或坐标值
 *给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 *
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 *
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 */
class KthLargestValue {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(KthLargestValue().kthLargestValue(arrayOf(intArrayOf(5, 2), intArrayOf(1, 6)), 1))
            println(KthLargestValue().kthLargestValue(arrayOf(intArrayOf(5, 2), intArrayOf(1, 6)), 2))
            println(KthLargestValue().kthLargestValue(arrayOf(intArrayOf(5, 2), intArrayOf(1, 6)), 3))
            println(KthLargestValue().kthLargestValue(arrayOf(intArrayOf(5, 2), intArrayOf(1, 6)), 4))
        }
    }

    /**
     * 时间：O(mnlog(mn))
     * 空间：O(mn)
     */
    fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
        val n = matrix.size
        val m = matrix[0].size
        val result = mutableListOf<Int>()

        val pre = Array(n + 1) {
            IntArray(m + 1)
        }

        for (i in 1..n) {
            for (j in 1..m) {
                pre[i][j] = pre[i - 1][j].xor(pre[i][j - 1]).xor(pre[i - 1][j - 1]).xor(matrix[i - 1][j - 1])
                result.add(pre[i][j])
            }
        }

        result.sortWith(Comparator { o1, o2 -> o2 - o1 })

        return result[k - 1]
    }
}