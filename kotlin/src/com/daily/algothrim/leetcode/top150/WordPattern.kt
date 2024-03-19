package com.daily.algothrim.leetcode.top150

/**
 * 290. 单词规律
 */

/*
给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。



示例1:

输入: pattern = "abba", s = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", s = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", s = "dog cat cat dog"
输出: false


提示:

1 <= pattern.length <= 300
pattern 只包含小写英文字母
1 <= s.length <= 3000
s 只包含小写英文字母和 ' '
s 不包含 任何前导或尾随对空格
s 中每个单词都被 单个空格 分隔
 */
class WordPattern {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(WordPattern().wordPattern("abba", "dog cat cat dog"))
            println(WordPattern().wordPattern("abba", "dog cat cat fish"))
            println(WordPattern().wordPattern("aaaa", "dog cat cat dog"))
        }
    }

    fun wordPattern(pattern: String, s: String): Boolean {
        val pMap = hashMapOf<Char, String>()
        val sMap = hashMapOf<String, Char>()
        val ss = s.split(" ")
        if (ss.size != pattern.length) return false

        for (i in pattern.indices) {
            if (pMap.containsKey(pattern[i]) && pMap[pattern[i]] != ss[i] || sMap.containsKey(ss[i]) && sMap[ss[i]] != pattern[i]) return false
            pMap[pattern[i]] = ss[i]
            sMap[ss[i]] = pattern[i]
        }

        return true
    }
}