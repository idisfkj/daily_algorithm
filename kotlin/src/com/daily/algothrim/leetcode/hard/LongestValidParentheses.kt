package com.daily.algothrim.leetcode.hard

import java.util.*

/**
 * 32. 最长有效括号
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
class LongestValidParentheses {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(LongestValidParentheses().longestValidParentheses("(()"))
            println(LongestValidParentheses().longestValidParentheses(")()())"))
            println(LongestValidParentheses().longestValidParentheses(""))
            println(LongestValidParentheses().longestValidParentheses("()(()"))
        }
    }

    // s = ")()())"
    // 4
    fun longestValidParentheses(s: String): Int {
        val stack = Stack<Int>()
        stack.push(-1)
        val length = s.length
        var i = 0
        var max = 0

        while (i < length) {
            if (s[i] == ')') {
                stack.pop()
                if (stack.isNotEmpty()) {
                    max = Math.max(max, i - stack.peek())
                } else {
                    stack.push(i)
                }
            } else {
                stack.push(i)
            }
            i++
        }

        return max
    }
}