package com.daily.algothrim.leetcode.top150

/**
 * 567. 字符串的排列
 */

/*
给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。

换句话说，s1 的排列之一是 s2 的 子串 。



示例 1：

输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").
示例 2：

输入：s1= "ab" s2 = "eidboaoo"
输出：false


提示：

1 <= s1.length, s2.length <= 104
s1 和 s2 仅包含小写字母
 */
class CheckInclusion {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CheckInclusion().checkInclusion("ab", "eidbaooo"))
        }
    }

    /**
     * O(n + m + 字母集)
     * O(字母集)
     */
    fun checkInclusion(s1: String, s2: String): Boolean {
        val n = s1.length
        val m = s2.length
        if (n > m) return false
        val ct1 = IntArray(26)
        val ct2 = IntArray(26)
        for (i in 0 until n) {
            ct1[s1[i] - 'a']++
            ct2[s2[i] - 'a']++
        }
        if (ct1.contentEquals(ct2)) {
            return true
        }

        for (j in n until m) {
            ct2[s2[j] - 'a']++
            ct2[s2[j - n] - 'a']--
            if (ct1.contentEquals(ct2)) return true
        }
        return false
    }
}