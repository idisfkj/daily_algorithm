package com.daily.algothrim.leetcode.easy

import java.util.*

/**
 * 20. 有效的括号
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 *  有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 */
class IsValid {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(IsValid().isValid("()"))
            println(IsValid().isValid("()[]{}"))
            println(IsValid().isValid("(]"))
            println(IsValid().isValid("{[]}"))
        }
    }

    // {[]}
    // ()[]{}
    fun isValid(s: String): Boolean {
        val length = s.length
        var i = 0
        val stack = Stack<Char>()
        while (i < length) {
            val char = s[i++]
            if (char == '(' || char == '[' || char == '{') {
                stack.push(char)
            } else if (stack.isEmpty() || (char == ')' && stack.peek() != '(') || (char == ']' && stack.peek() != '[') || (char == '}' && stack.peek() != '{')) {
                return false
            } else {
                stack.pop()
            }
        }
        return stack.isEmpty() // notice
    }
}