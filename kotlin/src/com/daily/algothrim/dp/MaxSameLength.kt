package com.daily.algothrim.dp

import kotlin.math.max

/**
 * 最多公共子串长度
 * 求把一个字符串变成另一个字符串，可以进行编辑，但只可以进行增加与删除
 * 求编辑过程中原子串最多的公共长度
 */
class MaxSameLength {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MaxSameLength().maxSameLength("mitcmu".toCharArray(), "mtacnu".toCharArray(), 6, 6))
        }
    }

    fun maxSameLength(a: CharArray, b: CharArray, n: Int, m: Int): Int {
        val status = Array(n) { IntArray(m) }

        var p = 0
        while (p < n) { // 初始化第一列
            when {
                a[p] == b[0] -> status[p][0] = 1
                p != 0 -> status[p][0] = status[p - 1][0]
                else -> status[p][0] = 0
            }
            p++
        }

        var q = 0
        while (q < m) { // 初始化第一行
            when {
                a[0] == b[q] -> status[0][q] = 1
                q != 0 -> status[0][q] = status[0][q - 1]
                else -> status[0][q] = 0
            }
            q++
        }

        // 1. a[n] == b[m] status[n][m] = max(status[n-1][m], status[n][m-1], status[n-1][m-1] + 1)
        // 2. a[n] != b[m] status[n][m] = max(status[n-1][m], status[n][m-1], status[n-1][m-1])

        var k = 1
        while (k < n) { // 填充剩余的行列，按行填充
            var j = 1
            while (j < m) {
                if (a[k] == b[j]) {
                    status[k][j] = max(max(status[k - 1][j], status[k][j - 1]), status[k - 1][j - 1] + 1)
                } else {
                    status[k][j] = max(max(status[k - 1][j], status[k][j - 1]), status[k - 1][j - 1])
                }
                j++
            }
            k++
        }
        return status[n - 1][m - 1]

    }
}