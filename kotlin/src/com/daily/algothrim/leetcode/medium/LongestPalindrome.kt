package com.daily.algothrim.leetcode.medium

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
class LongestPalindrome {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(LongestPalindrome().longestPalindrome("babad"))
            println(LongestPalindrome().longestPalindrome("cbbd"))
            println(LongestPalindrome().longestPalindrome("a"))
            println(LongestPalindrome().longestPalindrome("ac"))
            println(LongestPalindrome().longestPalindrome("ccc"))
        }
    }

    var finalStart = 0
    var finalEnd = 0
    var maxLength = 0

    fun longestPalindrome(s: String): String {
        val length = s.length
        s.forEachIndexed { index, _ ->
            checkPalindrome(s, index, index)
            if (index + 1 < length) {
                checkPalindrome(s, index, index + 1)
            }
        }
        return s.substring(finalStart, finalEnd + 1)
    }

    private fun checkPalindrome(s: String, left: Int, right: Int) {
        val length = s.length
        var start = left
        var end = right
        while (start >= 0 && end < length) {
            if (s[start] == s[end]) {
                start--
                end++
                continue
            }
            break
        }
        end--
        start++
        if (end - start + 1 > maxLength) {
            maxLength = end - start + 1
            finalStart = start
            finalEnd = end
        }
    }
}
