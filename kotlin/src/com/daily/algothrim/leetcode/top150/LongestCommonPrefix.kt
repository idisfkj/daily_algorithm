package com.daily.algothrim.leetcode.top150

import kotlin.math.min

/**
 * 14. 最长公共前缀
 */

/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。



示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。


提示：

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成
 */
class LongestCommonPrefix {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(LongestCommonPrefix().longestCommonPrefix(arrayOf("flower","flow","flight")))
            println(LongestCommonPrefix().longestCommonPrefix(arrayOf("dog","racecar","car")))
        }
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        var result = strs[0]
        for (i in 1 until strs.size) {
            val minLength = min(result.length, strs[i].length)
            var j = 0
            while (j < minLength) {
                if (result[j] != strs[i][j]) break
                j++
            }
            result = result.substring(0, j)
            if (result.isEmpty()) break
        }
        return result
    }
}