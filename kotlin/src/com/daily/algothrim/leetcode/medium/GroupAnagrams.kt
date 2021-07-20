package com.daily.algothrim.leetcode.medium

import java.lang.StringBuilder

/**
 * 49. 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词指字母相同，但排列不同的字符串。
 */
class GroupAnagrams {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            GroupAnagrams().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).forEach {
                it.forEach { item ->
                    println(item)
                }
                println()
            }
            GroupAnagrams().groupAnagrams(arrayOf("")).forEach {
                it.forEach { item ->
                    println(item)
                }
                println()
            }
            GroupAnagrams().groupAnagrams(arrayOf("a")).forEach {
                it.forEach { item ->
                    println(item)
                }
                println()
            }
        }
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = hashMapOf<String, ArrayList<String>>()

        strs.forEach {
            val bucket = IntArray(26)
            it.forEach { char ->
                bucket[char - 'a']++
            }

            val sb = StringBuilder()
            bucket.forEachIndexed { index, i ->
                if (i > 0) {
                    sb.append('a' + index)
                    sb.append(i)
                }
            }
            val key = sb.toString()
            val list = map.getOrDefault(key, arrayListOf())
            list.add(it)
            map[key] = list
        }

        return ArrayList<List<String>>(map.values)
    }
}