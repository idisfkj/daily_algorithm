package com.daily.algothrim.leetcode.top150

/**
 * 240. 搜索二维矩阵 II
 */

/*
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。

示例 1：

输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
输出：true
示例 2：

输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
输出：false
 
提示：

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
每行的所有元素从左到右升序排列
每列的所有元素从上到下升序排列
-109 <= target <= 109
 */
class SearchMatrix {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                SearchMatrix().searchMatrix(
                    arrayOf(
                        intArrayOf(1, 4, 7, 11, 15),
                        intArrayOf(2, 5, 8, 12, 19),
                        intArrayOf(3, 6, 9, 16, 22),
                        intArrayOf(10, 13, 14, 17, 24),
                        intArrayOf(18, 21, 23, 26, 30)
                    ), 20
                )
            )
        }
    }

    /**
     * O(n + m)
     * O(1)
     */
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return false
        val row = matrix.size
        val column = matrix[0].size

        var i = 0
        var j = column - 1

        while (i < row && j >= 0) {
            if (matrix[i][j] == target) return true
            if (matrix[i][j] > target) {
                j--
            } else {
                i++
            }
        }
        return false
    }
}