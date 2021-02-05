package com.daily.algothrim.leetcode

import kotlin.math.abs
import kotlin.math.max

/**
 * 1208. 尽可能使字符串相等
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 */
class EqualSubstring {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(EqualSubstring().solution("abcd", "bcdf", 3))
            println(EqualSubstring().solution("abcd", "cdef", 3))
            println(EqualSubstring().solution("abcd", "acde", 0))
        }
    }

    // 输入：s = "abcd", t = "bcdf", cost = 3
    // 输出：3
    // 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
    // 双指针，滑动窗口
    fun solution(s: String, t: String, maxCost: Int): Int {
        var max = 0
        var i = 0
        var j = 0
        val length = s.length
        var currentCost = 0

        while (i < length) {
            val sub = abs(s[i] - t[i])
            when {
                currentCost + sub <= maxCost -> {
                    currentCost += sub
                    i++
                }
                i != j -> {
                    currentCost -= abs(s[j] - t[j])
                    max = max(max, i - j)
                    j++
                }
                else -> {
                    i++
                    j++
                }
            }
        }

        max = max(max, i - j)

        return max
    }

}