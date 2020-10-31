package com.daily.algothrim.dp

import kotlin.math.min

/**
 * 最少编辑次数
 * 求把一个字符串变成另一个字符串，需要的最少编辑次数
 * 编辑内容包含：增加、删除、修改
 */
class MinEdit {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MinEdit().minEdit("mitcmu".toCharArray(), "mtacnu".toCharArray(), 6, 6))
        }
    }

    fun minEdit(a: CharArray, b: CharArray, n: Int, m: Int): Int {
        val status = Array(n) { IntArray(m) }

        // 1. 相同 a[ap+1]b[bp+1]
        // 2. 不相同
        // 2.1 a增/b 删 a[ap][bp+1]
        // 2.2 b增/a 删 a[ap+1][bp]
        // 2.3 ab修改成相同 a[ap+1][bp+1]

        // 1. a[n] == b[m] status[n][m] = min(status[n][m - 1] + 1, status[n - 1][m] + 1 ,status[n - 1][m - 1])
        // 2. a[n] != b[m] status[n][m] = min(status[n][m - 1], status[n - 1][m], status[n - ][m - 1]) + 1

        var p = 0
        while (p < n) { // 初始化第一列
            when {
                a[p] == b[0] -> status[p][0] = p
                p != 0 -> status[p][0] = status[p - 1][0] + 1
                else -> status[p][0] = 1
            }
            p++
        }

        var q = 0
        while (q < m) { // 初始化第一行
            when {
                a[0] == b[q] -> status[0][q] = q
                q != 0 -> status[0][q] = status[0][p - 1] + 1
                else -> status[0][q] = 1
            }
            q++
        }

        var k = 1
        while (k < n) { // 填充剩余行与列, 按行填充
            var j = 1
            while (j < m) {
                if (a[k] == b[j]) {
                    status[k][j] = min(min(status[k][j - 1] + 1, status[k - 1][j] + 1), status[k - 1][j - 1])
                } else {
                    status[k][j] = min(min(status[k][j - 1], status[k - 1][j]), status[k - 1][j - 1]) + 1
                }
                j++
            }
            k++
        }
        return status[n - 1][m - 1]
    }
}