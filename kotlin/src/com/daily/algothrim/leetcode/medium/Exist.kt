package com.daily.algothrim.leetcode.medium

/**
 * 79. 单词搜索
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
class Exist {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Exist().exist(arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
            ), "ABCCED"))

            println(Exist().exist(arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
            ), "SEE"))

            println(Exist().exist(arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
            ), "ABCB"))

            println(Exist().exist(arrayOf(
                    charArrayOf('a')
            ), "a"))
        }
    }

    // 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    // 输出：true
    fun exist(board: Array<CharArray>, word: String): Boolean {
        board.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                if (board[i][j] == word[0]) {
                    val result = backtracking(board, word, Array(board.size) { BooleanArray(board[0].size) }, i, j, 0)
                    if (result) return true
                }
            }
        }
        return false
    }

    private fun backtracking(board: Array<CharArray>, word: String, visited: Array<BooleanArray>, i: Int, j: Int, index: Int): Boolean {

        if (!visited[i][j] && board[i][j] == word[index]) {
            if (index == word.length - 1) return true
            visited[i][j] = true
            var left = false
            var up = false
            var right = false
            var bottom = false
            if (i > 0) {
                left = backtracking(board, word, visited, i - 1, j, index + 1)
            }
            if (j > 0 && !left) {
                up = backtracking(board, word, visited, i, j - 1, index + 1)
            }
            if (i < board.size - 1 && !left && !up) {
                right = backtracking(board, word, visited, i + 1, j, index + 1)
            }
            if (j < board[0].size - 1 && !left && !up && !right) {
                bottom = backtracking(board, word, visited, i, j + 1, index + 1)
            }
            visited[i][j] = false
            return left || up || right || bottom
        }
        return false
    }

}