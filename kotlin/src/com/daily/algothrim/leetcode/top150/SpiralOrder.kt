package com.daily.algothrim.leetcode.top150

/**
 * 54. 螺旋矩阵
 */

/*
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]


提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
class SpiralOrder {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpiralOrder().spiralOrder(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                )
            ).forEach {
                print("$it,")
            }
            println()
            SpiralOrder().spiralOrder(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12)
                )
            ).forEach {
                print("$it,")
            }
        }
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = arrayListOf<Int>()
        val rowCount = matrix.size
        val columnCount = matrix[0].size

        var top = 0
        var right = columnCount - 1
        var bottom = rowCount - 1
        var left = 0

        while (true) {
            // 四个循环为一个周期，每个循环后逆时针旋转90度
            // 1
            for (i in left..right) {
                result.add(matrix[top][i])
            }
            if (++top > bottom) break
            // 2
            for (i in top..bottom) {
                result.add(matrix[i][right])
            }
            if (--right < left) break
            // 3
            for (i in right downTo left) {
                result.add(matrix[bottom][i])
            }
            if (--bottom < top) break
            // 4
            for (i in bottom downTo top) {
                result.add(matrix[i][left])
            }
            if (++left > right) break
        }
        return result
    }
}