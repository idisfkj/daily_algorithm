package com.daily.algothrim.recursion

/**
 * 有效的井字游戏(LeetCode 794)
 *
 * 用字符串数组作为井字游戏的游戏板board。当且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。
 *
 * 该游戏板是一个 3 x 3 数组，由字符" "，"X"和"O"组成。字符" "代表一个空位。
 *
 * 以下是井字游戏的规则：
 *
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符 “X”，且第二个玩家总是放字符 “O”。
 * “X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 示例 1:
 * 输入: board = ["O  ", "   ", "   "]
 * 输出: false
 * 解释: 第一个玩家总是放置“X”。
 *
 * 示例 2:
 * 输入: board = ["XOX", " X ", "   "]
 * 输出: false
 * 解释: 玩家应该是轮流放置的。
 *
 * 示例 3:
 * 输入: board = ["XXX", "   ", "OOO"]
 * 输出: false
 *
 * 示例 4:
 * 输入: board = ["XOX", "O O", "XOX"]
 * 输出: true
 * 说明:
 *
 * 游戏板board是长度为 3 的字符串数组，其中每个字符串board[i]的长度为3。
 * board[i][j]是集合{" ", "X", "O"}中的一个字符。
 *
 * 1. 由于XO轮流走且X先走，所以X的数量一定大于等于O的数量
 * 2. 如果X赢，则X的数量一定比O的数量多1
 * 3. 如果O赢，则X的数据与O的数据一定相等
 * 4. 赢得条件就是行、列或者对角线其中有出现3个X或者O
 *
 * 实现方式不是递归，但LeetCode上将该问题归于递归分类...
 * 所以这里进行保留分类
 */
class ValidTicTacToe {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(ValidTicTacToe().validTicTacToe(arrayOf("O  ", "   ", "   ")))
            println(ValidTicTacToe().validTicTacToe(arrayOf("XOX", " X ", "   ")))
            println(ValidTicTacToe().validTicTacToe(arrayOf("XXX", "   ", "OOO")))
            println(ValidTicTacToe().validTicTacToe(arrayOf("XOX", "O O", "XOX")))
        }
    }

    fun validTicTacToe(board: Array<String>): Boolean {
        var xCount = 0
        var oCount = 0
        board.forEach {
            it.forEach { c ->
                if (c == 'X') xCount++
                if (c == 'O') oCount++
            }
        }

        if (xCount != oCount && oCount != xCount - 1) return false
        if (win(board, 'X') && oCount != xCount - 1) return false
        if (win(board, 'O') && oCount != xCount) return false

        return true
    }

    private fun win(board: Array<String>, p: Char): Boolean {
        repeat(3) {
            // 行
            if (board[it][0] == p && board[it][1] == p && board[it][2] == p) return true
            // 列
            if (board[0][it] == p && board[1][it] == p && board[2][it] == p) return true
        }

        // 对角
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) return true
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) return true

        return false
    }

}