package com.daily.algothrim.leetcode

/**
 * 51. N 皇后
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 提示：
 *
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */
class NQueens {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            NQueens().solution(8).forEach {
                it.forEach { sub ->
                    println("$sub,")
                }
                println()
            }
        }
    }

    fun solution(n: Int): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val queens = IntArray(n)
        calQueens(0, n, queens, result)
        return result
    }

    /**
     * O(n!)
     */
    private fun calQueens(row: Int, n: Int, queens: IntArray, result: MutableList<List<String>>) {
        if (row == n) {
            printlnQueens(n, queens, result)
            return
        }

        // 每一行都有n种放置方法
        repeat(n) {
            if (isOk(row, it, n, queens)) {
                // 记入放置的位置
                queens[row] = it
                // 下一行
                calQueens(row + 1, n, queens, result)
            }
        }

    }

    /**
     * 判断是否符合放置规则
     */
    private fun isOk(row: Int, column: Int, n: Int, queens: IntArray): Boolean {
        var leftUp = column - 1
        var rightUp = column + 1
        var up = row - 1

        // 与之前的行进行比较，判断是否符合规则
        while (up >= 0) {
            // 之前的行在当前列上是否已经存在
            if (queens[up] == column) return false
            // 左对角线是否存在
            if (leftUp >= 0 && queens[up] == leftUp) return false
            // 右对角线是否存在
            if (rightUp < n && queens[up] == rightUp) return false
            up--
            leftUp--
            rightUp++
        }
        return true
    }

    private fun printlnQueens(n: Int, queens: IntArray, result: MutableList<List<String>>) {
        val subResult = mutableListOf<String>()
        var i = 0
        while (i < n) {
            val sub = CharArray(n) { '.' }
            var j = 0
            while (j < n) {
                if (queens[i] == j) {
                    sub[j] = 'Q'
                }
                j++
            }
            subResult.add(String(sub))
            i++
        }
        result.add(subResult)
    }
}