package com.daily.algothrim.leetcode.medium

/**
 * 62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
class UniquePaths {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(UniquePaths().uniquePaths(3, 7))
            println(UniquePaths().uniquePaths(3, 2))
            println(UniquePaths().uniquePaths(7, 3))
            println(UniquePaths().uniquePaths(3, 3))
        }
    }

    // 输入：m = 3, n = 7
    // 输出：28
    fun uniquePaths(m: Int, n: Int): Int {
        val path = Array(m) { IntArray(n) }
        path[0][0] = 1
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == 0 && j == 0) continue
                if (i == 0 && j > 0) {
                    path[i][j] = path[i][j - 1]
                } else if (i > 0 && j == 0) {
                    path[i][j] = path[i - 1][j]
                } else {
                    path[i][j] = path[i - 1][j] + path[i][j - 1]
                }
            }
        }
        return path[m - 1][n - 1]
    }
}