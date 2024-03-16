package com.daily.algothrim.leetcode.top150

/**
 * 48. 旋转图像
 */

/*
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]
示例 2：


输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


提示：

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */
class RotateImage {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            )
            RotateImage().rotate(a)
            a.forEach {
                it.forEach { item ->
                    print("$item ,")
                }
                println()
            }
            println()
            val b = arrayOf(
                intArrayOf(5, 1, 9, 11),
                intArrayOf(2, 4, 8, 10),
                intArrayOf(13, 3, 6, 7),
                intArrayOf(15, 14, 12, 16)
            )
            RotateImage().rotate(b)
            b.forEach {
                it.forEach { item ->
                    print("$item ,")
                }
                println()
            }
        }
    }

    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        // 水平翻转
        var temp: Int
        for (i in 0 until n / 2) {
            for (j in 0 until n) {
                temp = matrix[i][j]
                matrix[i][j] = matrix[n - i - 1][j]
                matrix[n - i - 1][j] = temp
            }
        }

        // 对角线翻转
        for (i in 0 until n) {
            for (j in 0 until i) {
                temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
    }
}