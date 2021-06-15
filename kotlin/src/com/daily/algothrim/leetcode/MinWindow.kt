package com.daily.algothrim.leetcode

/**
 * 76. 最小覆盖子串
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
class MinWindow {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MinWindow().minWindow("ADOBECODEBANC", "ABC"))
        }
    }

    // 输入：s = "ADOBECODEBANC", t = "ABC"
    // 输出："BANC"
    fun minWindow(s: String, t: String): String {
        val tMap = hashMapOf<Char, Int>()
        val sMap = hashMapOf<Char, Int>()
        var fast = 0
        var slow = 0
        var l = -1
        var r = -1
        var minLen = Int.MAX_VALUE
        val len = s.length
        t.forEach {
            tMap[it] = tMap.getOrDefault(it, 0) + 1
        }

        while (fast < len) {
            if (tMap.containsKey(s[fast])) {
                sMap[s[fast]] = sMap.getOrDefault(s[fast], 0) + 1
            }
            while (check(tMap, sMap) && slow <= fast) {
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1
                    l = slow
                    r = fast + 1
                }
                if (tMap.containsKey(s[slow])) {
                    sMap[s[slow]] = sMap.getOrDefault(s[slow], 0) - 1
                }
                slow++
            }
            fast++
        }

        return if (l == -1) "" else s.substring(l, r)
    }

    private fun check(tMap: MutableMap<Char, Int>, sMap: MutableMap<Char, Int>): Boolean {
        tMap.iterator().forEach {
            if (sMap.getOrDefault(it.key, 0) < it.value) {
                return false
            }
        }
        return true
    }
}