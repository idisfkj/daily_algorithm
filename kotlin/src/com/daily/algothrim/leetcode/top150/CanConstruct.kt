package com.daily.algothrim.leetcode.top150

/**
 * 383. 赎金信
 */

/*
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。



示例 1：

输入：ransomNote = "a", magazine = "b"
输出：false
示例 2：

输入：ransomNote = "aa", magazine = "ab"
输出：false
示例 3：

输入：ransomNote = "aa", magazine = "aab"
输出：true


提示：

1 <= ransomNote.length, magazine.length <= 105
ransomNote 和 magazine 由小写英文字母组成
 */
class CanConstruct {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CanConstruct().canConstruct("a", "b"))
            println(CanConstruct().canConstruct("aa", "ab"))
            println(CanConstruct().canConstruct("aa", "aab"))
        }
    }

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val map = hashMapOf<Char, Int>()
        for (item in ransomNote) {
            map[item] = map.getOrDefault(item, 0) + 1
        }

        for (item in magazine) {
            if (map[item] != null) {
                map[item] = map.getOrDefault(item, 0) - 1
                if (map[item] == 0) {
                    map.remove(item)
                    if (map.size == 0) return true
                }
            }
        }

        return false
    }
}