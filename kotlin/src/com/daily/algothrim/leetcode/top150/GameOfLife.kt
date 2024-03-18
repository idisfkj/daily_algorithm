package com.daily.algothrim.leetcode.top150

import kotlin.math.absoluteValue

/**
 * 289. 生命游戏
 */

/*
根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。

给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。



示例 1：


输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
示例 2：


输入：board = [[1,1],[1,0]]
输出：[[1,1],[1,1]]


提示：

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] 为 0 或 1

 */

class GameOfLife {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var board = arrayOf(
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 1),
                intArrayOf(1, 1, 1),
                intArrayOf(0, 0, 0)
            )
            GameOfLife().gameOfLife(board)
            board.forEach {
                it.forEach { item ->
                    print("$item, ")
                }
                println()
            }
            println()
            board = arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 0)
            )
            GameOfLife().gameOfLife(board)
            board.forEach {
                it.forEach { item ->
                    print("$item, ")
                }
                println()
            }
        }
    }

    fun gameOfLife(board: Array<IntArray>) {
        val rowSize = board.size
        val columnSize = board[0].size

        for (i in 0 until rowSize) {
            for (j in 0 until columnSize) {
                val curr = board[i][j]
                val total = calculate(i, j, board, rowSize, columnSize)
                // 死 => 复活
                if (curr == 0 && total == 3) {
                    board[i][j] = 2
                    continue
                }
                // 活 => 死
                if (curr == 1 && (total > 3 || total < 2)) {
                    board[i][j] = -1
                }
            }
        }

        for (i in 0 until rowSize) {
            for (j in 0 until columnSize) {
                if (board[i][j] == 2) {
                    board[i][j] = 1
                }
                if (board[i][j] == -1) {
                    board[i][j] = 0
                }
            }
        }
    }

    private fun calculate(i: Int, j: Int, board: Array<IntArray>, rowSize: Int, columnSize: Int): Int {
        var total = 0
        if (j - 1 >= 0 && board[i][j - 1].absoluteValue == 1) {
            total++
        }
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1].absoluteValue == 1) {
            total++
        }
        if (i - 1 >= 0 && board[i - 1][j].absoluteValue == 1) {
            total++
        }
        if (i - 1 >= 0 && j + 1 < columnSize && board[i - 1][j + 1].absoluteValue == 1) {
            total++
        }
        if (j + 1 < columnSize && board[i][j + 1].absoluteValue == 1) {
            total++
        }
        if (i + 1 < rowSize && j + 1 < columnSize && board[i + 1][j + 1].absoluteValue == 1) {
            total++
        }
        if (i + 1 < rowSize && board[i + 1][j].absoluteValue == 1) {
            total++
        }
        if (i + 1 < rowSize && j - 1 >= 0 && board[i + 1][j - 1].absoluteValue == 1) {
            total++
        }
        return total
    }

}