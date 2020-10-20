package com.daily.algothrim.leetcode

import java.util.*

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 */
class LengthOfLongestSubstring {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(LengthOfLongestSubstring().solution("abcabcbb"))
            println(LengthOfLongestSubstring().solution("bbbbb"))
            println(LengthOfLongestSubstring().solution("pwwkew"))
            println()
            println(LengthOfLongestSubstring().solutionV2("abcabcbb"))
            println(LengthOfLongestSubstring().solutionV2("bbbbb"))
            println(LengthOfLongestSubstring().solutionV2("pwwkew"))
        }
    }

    fun solution(s: String): Int {
        var max = 0
        val deque = ArrayDeque<Char>()
        s.forEach {
            while (deque.contains(it)) {
                deque.removeFirst()
            }
            deque.add(it)
            max = deque.size.coerceAtLeast(max)
        }

        return max
    }

    /**
     * O(n)
     * 滑动窗口
     */
    fun solutionV2(s: String): Int {
        var max = 0
        var left = 0
        var right = 0
        val map = hashMapOf<Char, Int>()
        while (right < s.length) {
            if (map.contains(s[right]) && map[s[right]] ?: 0 >= left) {
                left = (map[s[right]] ?: 0) + 1
            }
            map[s[right]] = right
            max = max.coerceAtLeast(++right - left)
        }
        return max
    }
}