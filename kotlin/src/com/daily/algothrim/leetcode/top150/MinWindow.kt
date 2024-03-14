package com.daily.algothrim.leetcode.top150

/**
 * 76. 最小覆盖子串
 */

/*
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。



注意：

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。


示例 1：

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
示例 2：

输入：s = "a", t = "a"
输出："a"
解释：整个字符串 s 是最小覆盖子串。
示例 3:

输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。


提示：

m == s.length
n == t.length
1 <= m, n <= 105
s 和 t 由英文字母组成


进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 */
class MinWindow {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MinWindow().minWindow("ADOBECODEBANC", "ABC"))
            println(MinWindow().minWindow("a", "aa"))
            println(MinWindow().minWindow("a", "a"))
        }
    }

    fun minWindow(s: String, t: String): String {
        val sSize = s.length
        val tSize = t.length
        if (sSize < tSize) return ""

        val tMap = hashMapOf<Char, Int>()
        val currMap = hashMapOf<Char, Int>()
        t.forEach {
            tMap[it] = tMap.getOrDefault(it, 0) + 1
        }
        var minLength = Int.MAX_VALUE
        var left = 0
        var right = 0
        var resultLeft = -1
        var resultRight = -1

        while (right < sSize) {
            if (tMap.containsKey(s[right])) {
                currMap[s[right]] = currMap.getOrDefault(s[right], 0) + 1
            }
            while (checkSame(tMap, currMap) && left <= right) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1
                    resultLeft = left
                    resultRight = right + 1
                }
                if (currMap.containsKey(s[left])) {
                    currMap[s[left]] = currMap.getOrDefault(s[left], 0) - 1
                }
                left++
            }
            right++
        }
        return if (resultLeft < 0) "" else s.substring(resultLeft, resultRight)
    }

    private fun checkSame(tMap: HashMap<Char, Int>, currMap: HashMap<Char, Int>): Boolean {
        tMap.forEach {
            if (currMap.getOrDefault(it.key, 0) < it.value) {
                return false
            }
        }
        return true
    }
}