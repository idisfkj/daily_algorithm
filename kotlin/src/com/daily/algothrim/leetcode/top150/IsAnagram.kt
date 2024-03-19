package com.daily.algothrim.leetcode.top150

/**
 * 242. 有效的字母异位词
 */

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。



示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false


提示:

1 <= s.length, t.length <= 5 * 104
s 和 t 仅包含小写字母


进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
class IsAnagram {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(IsAnagram().isAnagram("anagram", "nagaram"))
            println(IsAnagram().isAnagram("rat", "car"))
        }
    }

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val map = hashMapOf<Char, Int>()
        for (item in s) {
            map[item] = map.getOrDefault(item, 0) + 1
        }
        for (item in t) {
            if (!map.containsKey(item)) return false
            if (map.getOrDefault(item, 0) == 1) {
                map.remove(item)
            } else {
                map[item] = map.getOrDefault(item, 0) - 1
            }
        }
        return map.size == 0
    }
}