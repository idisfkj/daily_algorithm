package com.daily.algothrim.leetcode.medium

/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
class MinPathSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                MinPathSum().minPathSum(
                    arrayOf(
                        intArrayOf(1, 3, 1),
                        intArrayOf(1, 5, 1),
                        intArrayOf(4, 2, 1)
                    )
                )
            )
            println(
                MinPathSum().minPathSum(
                    arrayOf(
                        intArrayOf(1, 2, 3),
                        intArrayOf(4, 5, 6)
                    )
                )
            )
        }
    }

    // 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
    // 输出：7
    // 解释：因为路径 1→3→1→1→1 的总和最小。
    fun minPathSum(grid: Array<IntArray>): Int {
        val r = grid.size
        val c = grid[0].size
        val minPath = Array(r) { IntArray(c) }
        minPath[0][0] = grid[0][0]

        for (i in 1 until r) {
            minPath[i][0] = minPath[i - 1][0] + grid[i][0]
        }

        for (j in 1 until c) {
            minPath[0][j] = minPath[0][j - 1] + grid[0][j]
        }

        for (i in 1 until r) {
            for (j in 1 until c) {
                minPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) + grid[i][j]
            }
        }

        return minPath[r - 1][c - 1]
    }
}