package com.daily.algothrim.leetcode

/**
 * 290. 单词规律
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 *  这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * */
class WordPattern {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(WordPattern().solution("abba", "dog cat cat dog"))
            println(WordPattern().solution("abba", "dog cat cat fish"))
            println(WordPattern().solution("aaaa", "dog cat cat dog"))
            println(WordPattern().solution("abba", "dog dog dog dog"))
        }
    }

    fun solution(pattern: String, s: String): Boolean {
        val sList = s.split(" ")
        if (pattern.length != sList.size) return false

        val pMap = hashMapOf<Char, String>()
        val sMap = hashMapOf<String, Char>()


        pattern.forEachIndexed { index, c ->
            val pValue = pMap[c]
            val sValue = sMap[sList[index]]

            if (pValue == null && sValue == null) {
                pMap[c] = sList[index]
                sMap[sList[index]] = c
            } else if (pValue != sList[index]) {
                return false
            }
        }

        return true
    }
}