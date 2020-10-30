package com.daily.algothrim.dp

import kotlin.math.min

/**
 * 棋盘最小路径
 *
 * 假设我们有一个 n 乘以 n 的矩阵 matrix[n][n]。矩阵存储的都是正整数。棋子起始位置在左上角，终止位置在右下角。
 * 我们将棋子从左上角移动到右下角。每次只能向右或者向下移动一位。从左上角到右下角，会有很多不同的路径可以走。
 * 我们把每条路径经过的数字加起来看作路径的长度。那从左上角移动到右下角的最短路径长度是多少呢?
 */
class MinDist {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MinDist().minDist(4, arrayOf(
                    intArrayOf(1, 3, 5, 9),
                    intArrayOf(2, 1, 3, 4),
                    intArrayOf(5, 2, 6, 7),
                    intArrayOf(6, 8, 4, 3)
            )))
            println(MinDist().minDist2(4, arrayOf(
                    intArrayOf(1, 3, 5, 9),
                    intArrayOf(2, 1, 3, 4),
                    intArrayOf(5, 2, 6, 7),
                    intArrayOf(6, 8, 4, 3)
            )))
        }
    }

    /**
     * 状态转移表法
     */
    fun minDist(n: Int, matrix: Array<IntArray>): Int {
        val status = Array(n) { IntArray(n) }

        var i = 0
        var rowSum = 0
        var columnSum = 0
        while (i < n) {
            // 初始化第一行
            rowSum += matrix[0][i]
            status[0][i] = rowSum

            // 初始化第一列
            columnSum += matrix[i][0]
            status[i][0] = columnSum
            i++
        }

        var k = 1
        // 剩余的按行填充
        while (k < n) {
            var m = 1
            while (m < n) {
                status[k][m] = matrix[k][m] + min(status[k - 1][m], status[k][m - 1])
                m++
            }
            k++
        }
        return status[n - 1][n - 1]
    }


    /**
     * 状态转移方程法
     */
    fun minDist2(n: Int, matrix: Array<IntArray>): Int {
        val status = Array(n) { IntArray(n) }

        var k = 0
        while (k < n) {
            var m = 0
            while (m < n) {
                var left = 0
                var up = 0

                if (k > 0) {
                    up = status[k - 1][m]
                }

                if (m > 0) {
                    left = status[k][m - 1]
                }

                when {
                    k == 0 -> status[k][m] = matrix[k][m] + left // 只能从左边过来
                    m == 0 -> status[k][m] = matrix[k][m] + up // 只能从上边过来
                    else -> status[k][m] = matrix[k][m] + min(up, left) // 左边、上边都可以过来
                }
                m++
            }
            k++
        }

        return status[n - 1][n - 1]
    }

}