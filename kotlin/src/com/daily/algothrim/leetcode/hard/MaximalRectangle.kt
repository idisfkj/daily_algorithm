package com.daily.algothrim.leetcode.hard

import java.util.*

/**
 * 85. 最大矩形
 *
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
class MaximalRectangle {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MaximalRectangle().maximalRectangle(arrayOf(
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('1', '0', '1', '1', '1'),
                    charArrayOf('1', '1', '1', '1', '1'),
                    charArrayOf('1', '0', '0', '1', '0')
            )))
            println(MaximalRectangle().maximalRectangle(arrayOf(
                    charArrayOf('1')
            )))
        }
    }

    // matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    // 6
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val m = matrix.size
        if (m == 0) return 0
        val n = matrix[0].size
        val left = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (if (j == 0) 0 else left[i][j - 1]) + 1
                }
            }
        }

        var result = 0
        for (j in 0 until n) {
            val up = IntArray(m)
            val down = IntArray(m)
            val stack = LinkedList<Int>()

            for (i in 0 until m) {
                while (stack.isNotEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop()
                }
                up[i] = if (stack.isEmpty()) -1 else stack.peek()
                stack.push(i)
            }
            stack.clear()
            for (i in m - 1 downTo 0) {
                while (stack.isNotEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop()
                }
                down[i] = if (stack.isEmpty()) m else stack.peek()
                stack.push(i)
            }

            for (i in 0 until m) {
                val height = down[i] - up[i] - 1
                val area = height * left[i][j]
                result = Math.max(result, area)
            }
        }

        return result
    }

}