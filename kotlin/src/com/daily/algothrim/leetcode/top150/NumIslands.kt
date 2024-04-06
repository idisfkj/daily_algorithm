package com.daily.algothrim.leetcode.top150

/**
 * 200. 岛屿数量
 */

/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。



示例 1：

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
示例 2：

输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3


提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'

 */
class NumIslands {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                NumIslands().numIslands(
                    arrayOf(
                        charArrayOf('1', '1', '1', '1', '0'),
                        charArrayOf('1', '1', '0', '1', '0'),
                        charArrayOf('1', '1', '0', '0', '0'),
                        charArrayOf('0', '0', '0', '0', '0')
                    )
                )
            )
        }
    }

    /**
     * O(mn)
     * O(mn)
     */
    fun numIslands(grid: Array<CharArray>): Int {
        val rowCount = grid.size
        val columnCount = grid[0].size
        var count = 0

        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                if (grid[i][j] == '1') {
                    count++
                    dfs(grid, i, rowCount, j, columnCount)
                }
            }
        }
        return count
    }

    private fun dfs(grid: Array<CharArray>, row: Int, rowCount: Int, column: Int, columnCount: Int) {
        if (row < 0 || row >= rowCount || column < 0 || column >= columnCount || grid[row][column] == '0') return
        grid[row][column] = '0'
        dfs(grid, row - 1, rowCount, column, columnCount)
        dfs(grid, row + 1, rowCount, column, columnCount)
        dfs(grid, row, rowCount, column - 1, columnCount)
        dfs(grid, row, rowCount, column + 1, columnCount)
    }
}