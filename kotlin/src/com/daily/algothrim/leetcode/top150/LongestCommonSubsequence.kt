package com.daily.algothrim.leetcode.top150

import kotlin.math.max

/**
 * 1143. 最长公共子序列
 */

/*
给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。



示例 1：

输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace" ，它的长度为 3 。
示例 2：

输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc" ，它的长度为 3 。
示例 3：

输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0 。


提示：

1 <= text1.length, text2.length <= 1000
text1 和 text2 仅由小写英文字符组成。

 */
class LongestCommonSubsequence {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"))
            println(LongestCommonSubsequence().longestCommonSubsequence("abc", "abc"))
            println(LongestCommonSubsequence().longestCommonSubsequence("abc", "def"))
        }
    }

    /**
     * O(nm)
     * O(nm)
     */
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val length1 = text1.length
        val length2 = text2.length
        if (length1 == 0 || length2 == 0) return 0

        val dp = Array(length1 + 1) { IntArray(length2 + 1) }
        for (i in 1..length1) {
            for (j in 1..length2) {
                if (text1[i - 1] == text2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[length1][length2]
    }
}