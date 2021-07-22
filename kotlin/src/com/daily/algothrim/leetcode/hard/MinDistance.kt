package com.daily.algothrim.leetcode.hard

/**
 * 72. 编辑距离
 *
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
class MinDistance {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MinDistance().minDistance("horse", "ros"))
            println(MinDistance().minDistance("intention", "execution"))
            println(MinDistance().minDistance("", "execution"))
            println(MinDistance().minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"))
        }
    }

    // word1 = "horse", word2 = "ros"
    // 3
    // horse -> rorse (将 'h' 替换为 'r')
    // rorse -> rose (删除 'r')
    // rose -> ros (删除 'e')

    // 1. 不相等 dp[n][m] = math.min(dp[n][m - 1], dp[n - 1][m], dp[n - 1][m - 1]) + 1 插入、删除、替换
    // 2. 相等 dp[n][m] = math.min(math.min(dp[i][j - 1], dp[i - 1][j]) + 1, dp[i - 1][j - 1])
    fun minDistance(word1: String, word2: String): Int {
        val n = word1.length
        val m = word2.length
        if ( n * m == 0) return n + m
        val dp = Array(n + 1) { IntArray(m + 1) }

        for (i in 0 .. n) {
            dp[i][0] = i
        }

        for (j in 0 .. m) {
            dp[0][j] = j
        }

        for (i in 1 .. n) {
            for (j in 1 .. m) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]) + 1, dp[i - 1][j - 1])
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1
                }
            }
        }

        return dp[n][m]
    }

}