package com.daily.algothrim.leetcode.top150

import kotlin.math.max

/**
 * 3. 无重复字符的最长子串
 */

/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长
子串
 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
 */
class LengthOfLongestSubstring {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"))
            println(LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"))
            println(LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"))
            println(LengthOfLongestSubstring().lengthOfLongestSubstring("cdd"))
            println(LengthOfLongestSubstring().lengthOfLongestSubstring("tmmzuxt"))
        }
    }

    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        if (n == 0) return 0
        val map = hashMapOf<Char, Int>()
        var maxLength = 0
        var start = 0
        for (i in s.indices) {
            if (map.containsKey(s[i])) {
                start = max(start, map.getOrDefault(s[i], 0) + 1)
            }
            map[s[i]] = i
            maxLength = max(maxLength, i - start + 1)
        }

        return maxLength
    }
}