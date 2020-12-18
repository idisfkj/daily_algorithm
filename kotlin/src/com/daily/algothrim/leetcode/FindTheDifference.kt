package com.daily.algothrim.leetcode

/**
 * 389. 找不同
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *  
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * */
class FindTheDifference {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(FindTheDifference().solution("abcd", "abcde"))
            println(FindTheDifference().solution("", "y"))
            println(FindTheDifference().solution("a", "aa"))
            println(FindTheDifference().solution("ae", "aea"))
            println()
            println(FindTheDifference().solution2("abcd", "abcde"))
            println(FindTheDifference().solution2("", "y"))
            println(FindTheDifference().solution2("a", "aa"))
            println(FindTheDifference().solution2("ae", "aea"))
            println()
            println(FindTheDifference().solution3("abcd", "abcde"))
            println(FindTheDifference().solution3("", "y"))
            println(FindTheDifference().solution3("a", "aa"))
            println(FindTheDifference().solution3("ae", "aea"))
            println()
            println(FindTheDifference().solution4("abcd", "abcde"))
            println(FindTheDifference().solution4("", "y"))
            println(FindTheDifference().solution4("a", "aa"))
            println(FindTheDifference().solution4("ae", "aea"))
        }
    }

    /**
     * 哈希
     * 时间：O(n)
     * 空间：O(n)
     */
    fun solution(s: String, t: String): Char {
        val map = hashMapOf<Char, Int>()
        s.forEach {
            map[it] = map[it]?.plus(1) ?: 1
        }

        t.forEach {
            if (map[it] == null || map[it] == 0) return it
            map[it] = map[it]?.minus(1) ?: 0
        }

        return ' '
    }

    /**
     * 计数
     * 时间：O(n)
     * 空间：O(n)
     */
    fun solution2(s: String, t: String): Char {
        val a = 'a'.toInt()
        val bucket = IntArray(26)
        s.forEach {
            bucket[it.toInt() - a]++
        }

        t.forEach {
            if (bucket[it.toInt() - a] == 0) return it

            bucket[it.toInt() - a]--
        }

        return ' '
    }

    /**
     * 求和
     * 时间：O(n)
     * 空间：O(1)
     */
    fun solution3(s: String, t: String): Char {
        var sSum = 0
        var tSum = 0
        s.forEach {
            sSum += it.toInt()
        }
        t.forEach {
            tSum += it.toInt()
        }
        return (tSum - sSum).toChar()
    }

    /**
     * 位运算
     * 时间：O(n)
     * 空间：O(1)
     */
    fun solution4(s: String, t: String): Char {
        var r = 0

        s.forEach {
            r = r.xor(it.toInt())
        }

        t.forEach {
            r = r.xor(it.toInt())
        }

        return r.toChar()
    }
}