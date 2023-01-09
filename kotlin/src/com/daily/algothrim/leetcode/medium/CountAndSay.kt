package com.daily.algothrim.leetcode.medium

import java.lang.StringBuilder

/**
 * 38. 外观数列
 */
class CountAndSay {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(CountAndSay().countAndSay(1))
            println(CountAndSay().countAndSay(4))
        }
    }

    fun countAndSay(n: Int): String {
        var str = "1"
        for (i in 2..n) {
            val sb = StringBuilder()
            var start = 0
            var curr = 0
            while (curr < str.length) {
                while (curr < str.length && str[curr] == str[start]) {
                    curr++
                }
                sb.append(curr - start).append(str[start])
                start = curr
            }
            str = sb.toString()
        }
        return str
    }
}