package com.daily.algothrim.leetcode.top150

/**
 * 5. 最长回文子串
 */

/*
给你一个字符串 s，找到 s 中最长的回文
子串
。

如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"

提示：

1 <= s.length <= 1000
s 仅由数字和英文字母组成
 */
class LongestPalindrome {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(LongestPalindrome().longestPalindrome("babad"))
            println(LongestPalindrome().longestPalindrome("cbbd"))
            println(LongestPalindrome().longestPalindrome("bb"))
        }
    }

    /**
     * O(n2)
     * O(n2)
     */
    fun longestPalindrome(s: String): String {
        val length = s.length
        val dp = Array(length) { BooleanArray(length) }

        for (i in 0 until length) {
            dp[i][i] = true
        }

        var maxLength = 1
        var start = 0

        for (l in 2..length) {
            for (i in 0 until length) {
                val j = l + i - 1
                if (j >= length) break
                if (s[i] != s[j]) {
                    dp[i][j] = false
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true
                    } else {
                        dp[i][j] = dp[i + 1][j - 1]
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1
                    start = i
                }
            }
        }

        return s.substring(start, start + maxLength)
    }
}