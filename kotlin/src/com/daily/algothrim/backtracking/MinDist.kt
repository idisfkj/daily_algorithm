package com.daily.algothrim.backtracking

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
            MinDist().apply {
                minDist(0, 0, arrayOf(
                        intArrayOf(1, 3, 5, 9),
                        intArrayOf(2, 1, 3, 4),
                        intArrayOf(5, 2, 6, 7),
                        intArrayOf(6, 8, 4, 3)
                ), 4, 0)
                println(mMinDist)
            }
        }
    }

    private var mMinDist = Int.MAX_VALUE

    fun minDist(row: Int, column: Int, matrix: Array<IntArray>, n: Int, dist: Int) {
        // (row == n && column == n - 1) 最后一步是从上到下到达终点
        // (column == n && row == n - 1) 最后一步是从左到右达到终点
        if ((row == n && column == n - 1) || (column == n && row == n - 1)) {
            if (dist < mMinDist) mMinDist = dist
            return
        }

        if (row == n || column == n) return

        minDist(row + 1, column, matrix, n, dist + matrix[row][column])

        minDist(row, column + 1, matrix, n, dist + matrix[row][column])
    }
}