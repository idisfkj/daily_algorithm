package com.daily.algothrim.leetcode.easy

/**
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
class LongestCommonPrefix {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                LongestCommonPrefix().longestCommonPrefix(
                    arrayOf(
                        "flower", "flow", "flight"
                    )
                )
            )
            println(
                LongestCommonPrefix().longestCommonPrefix(
                    arrayOf(
                        "dog", "racecar", "car"
                    )
                )
            )
        }
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        var result = strs[0]

        for (i in 1 until strs.size) {
            val length = Math.min(result.length, strs[i].length)
            var j = 0
            while (j < length && result[j] == strs[i][j]) {
                j++
            }
            result = result.substring(0, j)
            if (result.isEmpty()) break
        }

        return result
    }
}