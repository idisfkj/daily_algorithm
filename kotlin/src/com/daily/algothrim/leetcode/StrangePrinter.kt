package com.daily.algothrim.leetcode

/**
 * 664: 奇怪的打印机
 *
 * 有台奇怪的打印机有以下两个特殊要求：
 *
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 */
class StrangePrinter {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(StrangePrinter().strangePrinter("aaaabbb"))
            println(StrangePrinter().strangePrinter("aba"))
        }
    }

    /**
     * 时间：O(n3)
     * 空间：(n2)
     */
    fun strangePrinter(s: String): Int {
        val n = s.length
        val f = Array(n) {
            IntArray(n)
        }

        var i = n - 1
        while (i >= 0) {
            f[i][i] = 1
            for (j in i + 1 until n) {
                if (s[i] == s[j]) {
                    f[i][j] = f[i][j - 1]
                } else {
                    var min = Int.MAX_VALUE
                    for (k in i until j) {
                        min = Math.min(min, f[i][k] + f[k + 1][j])
                    }
                    f[i][j] = min
                }
            }
            i--
        }
        return f[0][n - 1]
    }
}