package com.daily.algothrim.leetcode.top150

/**
 * 49. 字母异位词分组
 */

/*
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的所有字母得到的一个新单词。



示例 1:

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
示例 2:

输入: strs = [""]
输出: [[""]]
示例 3:

输入: strs = ["a"]
输出: [["a"]]


提示：

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] 仅包含小写字母
 */
class GroupAnagrams {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            GroupAnagrams().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).forEach {
                it.forEach { item ->
                    print("$item, ")
                }
                println()
            }
            println()
            GroupAnagrams().groupAnagrams(arrayOf("")).forEach {
                it.forEach { item ->
                    print("$item, ")
                }
                println()
            }
            println()
            GroupAnagrams().groupAnagrams(arrayOf("a")).forEach {
                it.forEach { item ->
                    print("$item, ")
                }
                println()
            }
            println()
        }
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = hashMapOf<String, ArrayList<String>>()
        for (item in strs) {
            val c = item.toCharArray().apply { sort() }.concatToString()
            map[c] = map.getOrDefault(c, arrayListOf()).apply { add(item) }
        }

        val result = arrayListOf<List<String>>()
        for (item in map) {
            result.add(item.value)
        }
        return result
    }

}