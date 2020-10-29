package com.daily.algothrim.dp

import kotlin.math.min

/**
 * 杨辉三角变体
 *
 * 每个位置的数字可以随意填写，经过某个数字只能到达下面一层相邻的两个数字。
 * 假设你站在第一层，往下移动，我们把移动到最底层所经过的所有数字之和，定义为路径的长度。请你编程求出从最高层移动到最底层的最短路径长度。
 */
class YangHuiTriangleVer {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(YangHuiTriangleVer().yangHuiTriangle(arrayOf(
                    intArrayOf(5),
                    intArrayOf(7, 8),
                    intArrayOf(2, 3, 4),
                    intArrayOf(4, 9, 6, 1),
                    intArrayOf(2, 7, 9, 4, 5)
            ), 5))
        }
    }

    fun yangHuiTriangle(matrix: Array<IntArray>, n: Int): Int {
        val status = Array(n) { IntArray(n) }
        status[0][0] = matrix[0][0]

        var i = 1

        while (i < n) {
            var k = 0
            while (k <= i) {
                when (k) {
                    0 -> status[i][k] = status[i - 1][k] + matrix[i][k]
                    i -> status[i][k] = status[i - 1][k - 1] + matrix[i][k]
                    else -> status[i][k] = min(status[i - 1][k - 1], status[i - 1][k]) + matrix[i][k]
                }
                k++
            }
            i++
        }

        var min = Int.MAX_VALUE
        status[n - 1].forEach {
            if (it < min) min = it
        }

        return min
    }
}