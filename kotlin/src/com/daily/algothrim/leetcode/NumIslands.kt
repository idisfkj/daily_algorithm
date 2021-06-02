package com.daily.algothrim.leetcode

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
class NumIslands {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(NumIslands().numIslands(
                arrayOf(
                    charArrayOf('1', '1', '1', '1', '0'),
                    charArrayOf('1', '1', '0', '1', '0'),
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            ))
        }
    }

    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isNullOrEmpty() || grid[0].isEmpty()) return 0
        var result = 0
        val r = grid.size
        val c = grid[0].size

        for (ir in 0 until r) {
            for (ic in 0 until c) {
                if (grid[ir][ic] == '1') {
                    result++
                    dfs(r, c, ir, ic, grid)
                }
            }
        }

        return result
    }

    private fun dfs(r: Int, c: Int, ir: Int, ic: Int, grid: Array<CharArray>) {
        if (ir < 0 || ic < 0 || ir >= r || ic >= c || grid[ir][ic] == '0') return

        grid[ir][ic] = '0'
        dfs(r, c, ir - 1, ic, grid)
        dfs(r, c, ir + 1, ic, grid)
        dfs(r, c, ir, ic - 1, grid)
        dfs(r, c, ir, ic + 1, grid)
    }
}